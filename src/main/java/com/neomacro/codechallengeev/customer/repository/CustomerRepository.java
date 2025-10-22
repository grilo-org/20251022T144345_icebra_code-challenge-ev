package com.neomacro.codechallengeev.customer.repository;

import com.neomacro.codechallengeev.customer.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.rest.core.annotation.*;

import java.util.*;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    Optional<CustomerModel> findByEmail(String email);
}
