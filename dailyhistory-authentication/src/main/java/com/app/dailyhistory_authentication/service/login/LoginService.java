package com.app.dailyhistory_authentication.service.login;

import com.app.dailyhistory_authentication.DTOS.LoginRequestDTO;
import com.app.dailyhistory_authentication.DTOS.LoginResponseDTO;
import com.app.dailyhistory_authentication.domain.Role;
import com.app.dailyhistory_authentication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class LoginService implements LoginServiceInterface {

    private final UserRepository userRepository;
    private final JwtEncoder jwtEncoder;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    public LoginService(UserRepository userRepository, JwtEncoder jwtEncoder, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.jwtEncoder = jwtEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public LoginResponseDTO makeLogin(LoginRequestDTO loginRequestDTO) {

        try {

            var user = userRepository.findByEmail(loginRequestDTO.email());

            if (user.isEmpty() || !user.get().isLoginCorrect(loginRequestDTO, bCryptPasswordEncoder)) {

                throw new BadCredentialsException("Login / password incorrect !");

            }

            var now = Instant.now();
            var expiresIn = 300L;

            var scopes = user.get().getRoles()
                    .stream()
                    .map(Role::getRoleName)
                    .collect(Collectors.joining(""));

            var claims = JwtClaimsSet.builder()
                    .issuer("MyBackEnd")
                    .subject(user.get().getId().toString())
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiresIn))
                    .claim("scope", scopes)
                    .build();

            var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
            return new LoginResponseDTO(jwtValue , expiresIn);

        } catch (BadCredentialsException exception){

            logger.error("Invalid credentials!",exception.getMessage() , exception);
            throw new BadCredentialsException("Invalid Login!");

        }

    }
}
