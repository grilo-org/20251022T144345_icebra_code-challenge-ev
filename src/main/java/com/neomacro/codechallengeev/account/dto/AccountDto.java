package com.neomacro.codechallengeev.account.dto;

import com.fasterxml.jackson.annotation.*;
import com.neomacro.codechallengeev.customer.dto.*;
import lombok.*;
import lombok.experimental.*;

import java.math.*;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto {

    private CustomerDto customerDto;

    private BigDecimal balance;

    private int numberOfWithdraws;
}