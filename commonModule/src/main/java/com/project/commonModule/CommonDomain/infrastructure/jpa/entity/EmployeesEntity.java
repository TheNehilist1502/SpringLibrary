package com.project.commonModule.Common.infrastructure.jpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

    @Entity
    @DiscriminatorValue("Employees")
    public class Employees extends SuperUsers {

    }

