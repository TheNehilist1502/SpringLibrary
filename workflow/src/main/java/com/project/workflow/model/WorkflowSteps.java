package com.project.workflow.model;


import com.project.commonModule.models.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class WorkflowSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int workflow;
    int step;
    @Enumerated
    Role role;
}
