package com.app.dailyhistory_authentication.service.register;

import com.app.dailyhistory_authentication.DTOS.RegisterUserDTO;
import com.app.dailyhistory_authentication.domain.Role;
import com.app.dailyhistory_authentication.domain.User;
import com.app.dailyhistory_authentication.infra.EmailAlreadyExistException;
import com.app.dailyhistory_authentication.infra.PasswordLessThanEightCharacters;
import com.app.dailyhistory_authentication.infra.PasswordNotEqualsConfirmPasswordException;
import com.app.dailyhistory_authentication.repository.RoleRepository;
import com.app.dailyhistory_authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Set;

@Service
public class RegisterService implements RegisterServiceInterface{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Logger logger = LoggerFactory.getLogger(RegisterService.class);

    @Autowired
    public RegisterService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createAndSaveUser(RegisterUserDTO registerUserDTO) {

        try {

            var basicRole = roleRepository.findByName(Role.Values.BASIC.name());
            var emailFromDb = userRepository.findByEmail(registerUserDTO.email());
            if (emailFromDb.isPresent()) {

                throw new EmailAlreadyExistException("Email already exist !");

            }

            var newUser = new User();
            newUser.setEmail(registerUserDTO.email());
            newUser.setPassword(bCryptPasswordEncoder.encode(registerUserDTO.password()));
            newUser.setConfirmPassword(bCryptPasswordEncoder.encode(registerUserDTO.confirmPassword()));
            newUser.setRoles(Set.of(basicRole));
            this.checkPasswordEqualsAndLength(registerUserDTO);
            this.userRepository.save(newUser);
            return newUser;

        } catch (ResponseStatusException exception){

            logger.error("try again !" , exception.getMessage() , exception);
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        }
    }

    @Override
    public void checkPasswordEqualsAndLength(RegisterUserDTO registerUserDTO) {

        if (!Objects.equals(registerUserDTO.password(), registerUserDTO.confirmPassword())){

            logger.error("password and confirm password not equals!");
            throw new PasswordNotEqualsConfirmPasswordException("password not equals confirm password!"); // change the exception more later...

        }

        if (registerUserDTO.password().length() < 8){

            logger.error("password less than eight!");
            throw new PasswordLessThanEightCharacters("password needs eight ou more characters");

        }
    }
}
