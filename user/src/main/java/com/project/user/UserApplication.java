package com.project.user;

import com.project.commonModule.models.Role;
import com.project.commonModule.models.Status;
import com.project.commonModule.models.Users;
import com.project.commonModule.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {Users.class, UserRepository.class, Role.class, Status.class})
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
