package com.project.commonModule.models;

import jakarta.persistence.*;


    @Entity
    @DiscriminatorValue("Users")
    public class Users extends SuperUsers {

    }

