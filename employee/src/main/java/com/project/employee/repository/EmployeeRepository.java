package com.project.employee.repository;

import com.project.commonModule.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {

    Optional<Employees> getEmployeesByUsername(String employeeName);
}
