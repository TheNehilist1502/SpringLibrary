package com.project.workflow.repository;

import com.project.workflow.model.WorkFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowRepository extends JpaRepository<WorkFlow,Integer> {
    public WorkFlow getWorkFlowByName(String workflowName);
}
