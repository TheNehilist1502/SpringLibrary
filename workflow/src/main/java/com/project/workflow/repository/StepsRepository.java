package com.project.workflow.repository;


import com.project.workflow.model.Steps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepsRepository extends JpaRepository<Steps,Integer>{

 /*   @Override
    Steps findById(int stepId){

    }*/


}
