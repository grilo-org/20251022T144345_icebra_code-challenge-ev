package com.neomacro.codechallengeev.customer.service;

import com.neomacro.codechallengeev.customer.model.*;
import com.neomacro.codechallengeev.customer.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CustomerService {

    final CustomerRepository customerRepository;

    @Transactional
    public CustomerModel registration(CustomerModel customerModel) {
        return customerRepository.save(customerModel);
    }

    public Optional<CustomerModel> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}