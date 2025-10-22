package com.neomacro.codechallengeev.account.entity;

import com.neomacro.codechallengeev.customer.entity.CustomerEntity;
import lombok.*;

import javax.persistence.*;
import java.math.*;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private int accountNumber;

    @OneToOne
    @JoinColumn(name = "customer_fk", foreignKey = @ForeignKey(name = "customer", value = ConstraintMode.NO_CONSTRAINT))
    private CustomerEntity customer;

    private BigDecimal balance;

    private int numberOfWithdraws;
}
