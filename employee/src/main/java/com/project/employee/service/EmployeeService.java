package com.project.employee.service;


import com.project.commonModule.models.Role;
import com.project.commonModule.services.CommonService;
import com.project.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import com.project.commonModule.models.Employees;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final CommonService commonService= new CommonService(new RestTemplate());
    private final String role=Role.EMPLOYEE.toString();
        public List<Employees> viewEmployees(){
            String workflowName="read-employee";
            if(commonService.isEligable(workflowName, role)){
                return repository.findAll();
            }
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        public List<Employees> createEmployees(List<Employees> Employees){
            String workflowName="create-employee";
            if(commonService.isEligable(workflowName, role)){
                return repository.saveAll(Employees);
            }
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        public void deleteEmployees(@NonNull List<String> employeesNames){
            String workflowName="delete-employee";

            if(commonService.isEligable(workflowName, role)) {
                List<Employees> employeesList = null;
                for (String employeeName : employeesNames) {
                    employeesList.add(repository.getEmployeesByUsername(employeeName).get());
                }
                repository.deleteAll(employeesList);
            }
        }

}
