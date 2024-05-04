package com.project.workflow.repository;

import com.project.commonModule.models.Role;
import com.project.workflow.model.WorkFlow;
import com.project.workflow.model.WorkflowSteps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkflowStepsRepository extends JpaRepository<WorkflowSteps,Integer> {

    Optional <WorkflowSteps> getWorkflowStepsByWorkflowAndRole(int workflow, Role role);

}
