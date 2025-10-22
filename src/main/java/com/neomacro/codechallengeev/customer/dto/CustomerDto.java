package com.neomacro.codechallengeev.customer.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.*;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    private String email;

    private String name;
}