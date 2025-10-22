package com.neomacro.codechallengeev.account.dto.mapper;

import com.neomacro.codechallengeev.account.dto.*;
import com.neomacro.codechallengeev.account.model.*;
import com.neomacro.codechallengeev.customer.dto.mapper.*;

public class AccountMapper {
    public static AccountDto toCustomerDto(AccountModel account) {
        return new AccountDto()
                .setCustomerDto(CustomerMapper.toCustomerDto(account.getCustomer()))
                .setBalance(account.getBalance())
                .setNumberOfWithdraws(account.getNumberOfWithdraws());
    }
}