package com.app.dailyhistory_authentication.repository;

import com.app.dailyhistory_authentication.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {

    Role findByName(String name);


}
