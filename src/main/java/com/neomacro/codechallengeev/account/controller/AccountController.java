package com.neomacro.codechallengeev.account.controller;

import com.neomacro.codechallengeev.account.model.*;
import com.neomacro.codechallengeev.account.service.*;
import com.neomacro.codechallengeev.customer.model.*;
import com.neomacro.codechallengeev.customer.service.*;
import com.neomacro.codechallengeev.exception.*;
import com.neomacro.codechallengeev.withdraw.entity.*;
import com.neomacro.codechallengeev.withdraw.service.*;
import lombok.*;
import org.gradle.internal.impldep.com.google.common.primitives.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.hateoas.config.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.*;

import javax.servlet.http.*;
import java.math.*;
import java.time.*;
import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/")
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class AccountController {
    private static final int MAX_WITHDRAWAL_FIRST_TRANSACTION = 50;
    private static final int MAX_WITHDRAWAL_PER_TRANSACTION = 300;
    private static final int MAX_WITHDRAWAL_IN_24_HOURS = 5;

    private static final String ITEMS_BY_PAGE = "10";

    @Autowired
    private final AccountService accountService;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final WithdrawService withdrawService;

    @PostMapping(value = "/{email}/withdraw/{value}", produces = {"application/hal+json"})
    public ResponseEntity<Object> withdraw(@PathVariable final String email, @PathVariable final String value) {
        Optional<CustomerModel> customerModelOptional = customerService.findByEmail(email);

        if (!customerModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not registered.");
        }

        Optional<AccountModel> accountModelOptional = accountService.getAccountByEmail(email);

        if (accountModelOptional.isPresent()) {
            Optional<List<WithdrawEntity>> withdrawModelOptional = withdrawService.findLastWithdrawsByAccount(accountModelOptional.get().getAccountNumber(), MAX_WITHDRAWAL_IN_24_HOURS);

            BigDecimal withdrawValue = new BigDecimal(Optional.ofNullable(value).map(Doubles::tryParse).orElse(0.0));

            if (!withdrawModelOptional.isPresent() && withdrawValue.compareTo(BigDecimal.ZERO) > 0 && withdrawValue.compareTo(BigDecimal.valueOf(MAX_WITHDRAWAL_FIRST_TRANSACTION)) > 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("First withdraw is limited to US$" + MAX_WITHDRAWAL_FIRST_TRANSACTION + ".00.");
            }

            if (withdrawValue.compareTo(BigDecimal.ONE) < 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Minimum withdraw value is US$1.00.");
            }

            if (withdrawValue.compareTo(BigDecimal.valueOf(MAX_WITHDRAWAL_PER_TRANSACTION)) > 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Maximum withdraw value is US$" + MAX_WITHDRAWAL_PER_TRANSACTION + ".00.");
            }

            LocalDateTime dateNow = LocalDateTime.now();
            LocalDateTime dateOld = dateNow.minusDays(1);
            List<WithdrawEntity> listWithdrawalsExceeded = new ArrayList<WithdrawEntity>();

            withdrawModelOptional.get().stream().forEach(item -> {
                if (item.getWithdrawDate().isAfter(dateOld) && item.getWithdrawDate().isBefore(dateNow)) {
                    listWithdrawalsExceeded.add(item);
                }
            });
            // Stream<WithdrawEntity> streamWithdraw = withdrawModelOptional.map(List::stream).filter(stream.getWithdrawDate().isAfter(dateOld) && stream.getWithdrawDate().isBefore(dateNow)).orElse(Stream.empty());

            if (listWithdrawalsExceeded.stream().count() == MAX_WITHDRAWAL_IN_24_HOURS) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Maximum of " + MAX_WITHDRAWAL_IN_24_HOURS + " money withdrawals in 24 hours. Need more? Ask your manager for KING Plan.");
            }

            if (accountModelOptional.get().getBalance().compareTo(accountService.getWithdrawAndTax(withdrawValue)) < 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Insufficient funds");
            }

            return ResponseEntity.ok().body(accountService.withdraw(accountModelOptional.get(), withdrawValue));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Withdraw canceled");
    }

    @GetMapping(value = "/accounts", params = {"page", "size"}, produces = {"application/hal+json"})
    public List<AccountModel> accounts(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                       @RequestParam(value = "size", required = false, defaultValue = ITEMS_BY_PAGE) int size, UriComponentsBuilder uriBuilder,
                                       HttpServletResponse response) {

        Page<AccountModel> resultPage = accountService.findAllPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }

        return resultPage.getContent();
    }

    @GetMapping(value = "/{email}/balance", produces = {"application/hal+json"})
    public Optional<BigDecimal> balance(@PathVariable final String email, UriComponentsBuilder uriBuilder,
                                       HttpServletResponse response) {

        Optional<BigDecimal> balanceOptional = accountService.getBalance(email);

        return balanceOptional;
    }
}
