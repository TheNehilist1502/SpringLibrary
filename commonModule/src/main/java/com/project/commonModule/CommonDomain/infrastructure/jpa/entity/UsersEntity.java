package com.project.commonModule.Common.infrastructure.jpa.entity;

import com.project.commonModule.Common.infrastructure.jpa.entity.SuperUsers;
import jakarta.persistence.*;


    @Entity
    @DiscriminatorValue("Users")
    public class Users extends SuperUsers {

    }

