package com.neomacro.codechallengeev.customer.dto.mapper;

import com.neomacro.codechallengeev.customer.dto.*;
import com.neomacro.codechallengeev.customer.model.*;

public class CustomerMapper {
    public static CustomerDto toCustomerDto(CustomerModel customer) {
        return new CustomerDto()
                .setEmail(customer.getEmail())
                .setName(customer.getName());
    }
}