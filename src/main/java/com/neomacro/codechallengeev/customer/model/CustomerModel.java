package com.neomacro.codechallengeev.customer.model;

import lombok.*;
import lombok.experimental.*;
import org.springframework.data.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CustomerModel {

    @Id
    private String email;

    private String name;
}