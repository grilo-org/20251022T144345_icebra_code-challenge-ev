package com.neomacro.codechallengeev.customer.controller;

import com.neomacro.codechallengeev.customer.dto.*;
import com.neomacro.codechallengeev.customer.model.*;
import com.neomacro.codechallengeev.customer.service.*;
import lombok.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
@AllArgsConstructor
public class CustomerController {
    @Autowired
    private final CustomerService customerService;

    @PostMapping(value = "/registration")
    public ResponseEntity<Object> withdraw(@RequestBody @Valid CustomerDto customerDto) {
        var customerModel = new CustomerModel();

        BeanUtils.copyProperties(customerDto, customerModel);

        return ResponseEntity.ok().body(customerService.registration(customerModel));
    }
}
