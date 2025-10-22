package com.neomacro.codechallengeev.withdraw.service;

import com.neomacro.codechallengeev.withdraw.entity.*;
import com.neomacro.codechallengeev.withdraw.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WithdrawService {

    final WithdrawRepository withdrawRepository;

    public Optional<List<WithdrawEntity>> findLastWithdrawsByAccount(int accountNumber, int numberOfLastWithdraws) {
        return withdrawRepository.findLastWithdrawsByAccount(accountNumber, numberOfLastWithdraws);
    }
}
