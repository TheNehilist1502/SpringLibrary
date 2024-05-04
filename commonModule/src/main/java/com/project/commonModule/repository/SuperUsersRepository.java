package com.project.commonModule.repository;

import com.project.commonModule.models.SuperUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperUsersRepository extends JpaRepository<SuperUsers,Integer> {
    Optional<SuperUsers> getSuperUsersByUsername(String userName);

}
