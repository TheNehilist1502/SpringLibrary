package com.project.authServer.repository;


import com.project.authServer.model.AuthUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthUsers,Integer> {
    Optional<AuthUsers> findByUsername(String username);

}
