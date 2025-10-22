package com.neomacro.codechallengeev.withdraw.repository;

import com.neomacro.codechallengeev.withdraw.entity.*;
import com.neomacro.codechallengeev.withdraw.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.data.rest.core.annotation.*;

import java.util.*;

@RepositoryRestResource(collectionResourceRel = "withdraw", path = "withdraw")
public interface WithdrawRepository extends JpaRepository<WithdrawModel, Long> {

    @Query("from withdraw w order by w.withdrawDate desc fetch first :lastW rows only;")
    Optional<List<WithdrawEntity>> findLastWithdrawsByAccount(int accountNumber, @Param("lastW") int numberOfLastWithdraws);
}
