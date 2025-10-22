package com.neomacro.codechallengeev.account.repository;

import com.neomacro.codechallengeev.account.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

import java.math.*;
import java.util.*;

@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends JpaRepository<AccountModel, Long>, PagingAndSortingRepository<AccountModel, Long> {
    Optional<AccountModel> findByEmail(String email);

    @Query("FROM account a where a.email = :email;")
    Optional<BigDecimal> getBalanceByEmail(@Param("email") String email);

    @Query("FROM account a ")
    List<AccountModel> findAllPaginated(
            Pageable pageable);
}
