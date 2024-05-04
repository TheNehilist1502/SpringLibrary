package com.project.workflow.controller;


import com.project.workflow.service.WorkflowService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workflow")
public class WorkFlowController {
    private final WorkflowService workflowService;

    @GetMapping("/check-eligiability")
    public @ResponseBody String checkEligability(
            @RequestParam(name="workflowName") String workFlowName
            ,@RequestParam(name="token") String token){
                return workflowService.checkRoleEligability
                        (workFlowName,token);
    }
    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity<String> handleResponseStatusExceptions() {
        // Custom logic to handle exceptions
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("You are not allowed to do this.");
    }
}
