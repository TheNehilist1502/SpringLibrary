package com.project.commonModule.Common.infrastructure.jpa.repository;

import com.project.commonModule.Common.infrastructure.jpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
        Optional<Users> getUsersByUsername(String userName);
}
