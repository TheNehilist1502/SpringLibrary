package com.project.workflow.service;


import com.project.commonModule.models.Role;
import com.project.workflow.model.*;
import com.project.workflow.repository.StepsRepository;
import com.project.workflow.repository.WorkflowRepository;
import com.project.workflow.repository.WorkflowStepsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkflowService {

    private final WorkflowRepository workflowRepository;
    private final WorkflowStepsRepository workflowStepsRepository;
    private final StepsRepository stepsRepository;
    private final JwtService jwtService;
    




    public String checkRoleEligability(String workflowName, String token) throws ResponseStatusException{
        //TODO
        //draw a workflow.getWorkFlowByName() method
        //draw a getRole() method
        String role= jwtService.getUserRole(token);
        int workflow= workflowRepository.getWorkFlowByName(workflowName).getId();
        WorkflowSteps workflowStep=workflowStepsRepository
                .getWorkflowStepsByWorkflowAndRole(workflow, Role.valueOf(role))
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.FORBIDDEN));

        Optional<Steps> steps=stepsRepository.findById(workflowStep.getStep());

        String workflowStatus = steps
                .get()
                .getStatus()
                .toString();

        return workflowStatus;
    }
}
