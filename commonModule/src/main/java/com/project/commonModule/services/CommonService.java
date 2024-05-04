package com.project.commonModule.services;


import com.project.commonModule.models.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final RestTemplate restTemplate;
    public String getResponseStatus(String workflowName,String token) {
        // Perform actions before the controller method is called
        String checkWorkflowEligiabliltyURI="http://localhost:8080/workflow/check-eligiability?"
                +"workflowName="+workflowName
                +"&token="+ token;
        ResponseEntity<String> response = restTemplate.getForEntity(checkWorkflowEligiabliltyURI, String.class);
        return response.getBody();
    }

    public boolean isEligable(String workflowName,String token) {
        // Perform actions before the controller method is called
        return !getResponseStatus(workflowName, token).equals(Status.PROHIBITED.toString());
    }

}
