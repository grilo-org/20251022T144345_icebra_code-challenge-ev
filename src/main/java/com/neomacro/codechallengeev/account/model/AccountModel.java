package com.neomacro.codechallengeev.account.model;

import com.neomacro.codechallengeev.customer.model.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.annotation.*;

import java.math.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AccountModel {

    @Id
    private int accountNumber;

    private CustomerModel customer;

    private BigDecimal balance;

    private int numberOfWithdraws;
}