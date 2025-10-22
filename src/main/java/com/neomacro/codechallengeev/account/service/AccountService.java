package com.neomacro.codechallengeev.account.service;

import com.neomacro.codechallengeev.account.model.*;
import com.neomacro.codechallengeev.account.repository.*;
import com.neomacro.codechallengeev.withdraw.model.*;
import com.neomacro.codechallengeev.withdraw.repository.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import javax.transaction.*;
import java.math.*;
import java.time.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AccountService {
    private static final String DEFAULT_PAGE_FIELD_EMAIL = "email";
    final AccountRepository accountRepository;

    final WithdrawRepository withdrawRepository;

    public AccountModel deposit(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    @Transactional
    public AccountModel withdraw(AccountModel accountModel, BigDecimal value) {
        WithdrawModel wm = new WithdrawModel();
        wm.setAccount(accountModel);
        wm.setWithdrawDate(LocalDateTime.now(ZoneId.of("UTC")));
        wm.setValue(accountModel.getBalance());

        withdrawRepository.save(wm);

        accountModel.setBalance(accountModel.getBalance().subtract(getWithdrawAndTax(value)));

        return accountRepository.save(accountModel);
    }

    public Optional<AccountModel> getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Optional<BigDecimal> getBalance(String email) {
        return accountRepository.getBalanceByEmail(email);
    }

    public BigDecimal getWithdrawAndTax(BigDecimal value) {
        if (value.compareTo(BigDecimal.ONE) >= 0 && value.compareTo(BigDecimal.valueOf(100.99)) <= 0) {
            return value.add(value.multiply(BigDecimal.valueOf(0.03)));
        } else if (value.compareTo(BigDecimal.valueOf(101.00)) >= 0 && value.compareTo(BigDecimal.valueOf(250.99)) <= 0) {
            return value.add(value.multiply(BigDecimal.valueOf(0.02)));
        } else if (value.compareTo(BigDecimal.valueOf(251.00)) >= 0 && value.compareTo(BigDecimal.valueOf(300.00)) <= 0) {
            return value.add(value.multiply(BigDecimal.valueOf(0.01)));
        } else {
            return value;
        }
    }

    public Page<AccountModel> findAllPaginated(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, DEFAULT_PAGE_FIELD_EMAIL);

        return new PageImpl<>(accountRepository.findAllPaginated(pageRequest));
    }
}
