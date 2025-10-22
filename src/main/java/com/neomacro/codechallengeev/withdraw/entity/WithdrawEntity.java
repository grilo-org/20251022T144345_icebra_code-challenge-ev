package com.neomacro.codechallengeev.withdraw.entity;

import com.neomacro.codechallengeev.account.entity.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.math.*;
import java.time.*;

@Entity
@Table(name = "withdraw")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawEntity {

    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_fk", foreignKey = @ForeignKey(name = "account", value = ConstraintMode.NO_CONSTRAINT))
    @Column(unique=true)
    private AccountEntity account;

    private BigDecimal value;

    private LocalDateTime withdrawDate;
}
