package com.neomacro.codechallengeev.customer.entity;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity {

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String email;

    private String name;
}
