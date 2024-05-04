package com.project.user.service;
import com.project.commonModule.models.Role;
import com.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import com.project.commonModule.services.CommonService;
import com.project.commonModule.models.Users;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final CommonService commonService= new CommonService(new RestTemplate());
    String role=Role.USER.toString();


    public List<Users> readUsers(){
        String workflowName="read-user";
        if(commonService.isEligable(workflowName, role)){
            return repository.findAll();
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    public List<Users> createUsers(List<Users> users){
        String workflowName="create-user";
        if(commonService.isEligable(workflowName, role)){
            return repository.saveAll(users);
        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    public void deleteUsers(@NonNull List<String> userNames){
        String workflowName="delete-user";
        if(commonService.isEligable(workflowName, role)){
            List<Users> usersList = null;
            for(String userName: userNames) {
                usersList.add(repository.getUsersByUsername(userName).get());
            }
            repository.deleteAll(usersList);
        }

    }

}

