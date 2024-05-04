package com.project.employee;

import com.project.commonModule.models.Employees;
import com.project.commonModule.models.Role;
import com.project.commonModule.models.Status;
import com.project.commonModule.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {Employees.class, EmployeeRepository.class, Role.class, Status.class})
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
