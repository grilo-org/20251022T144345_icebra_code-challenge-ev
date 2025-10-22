package com.neomacro.codechallengeev.withdraw.model;

import com.neomacro.codechallengeev.account.model.*;
import lombok.*;
import lombok.experimental.*;
import org.springframework.data.annotation.*;

import java.math.*;
import java.time.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class WithdrawModel {

    @Id
    private AccountModel account;

    private BigDecimal value;

    private LocalDateTime withdrawDate;
}