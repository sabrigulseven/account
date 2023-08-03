package com.sabrigulseven.account.service;

import com.sabrigulseven.account.dto.AccountDto;
import com.sabrigulseven.account.dto.CreateAccountRequest;
import com.sabrigulseven.account.dto.converter.AccountDtoConverter;
import com.sabrigulseven.account.model.Account;
import com.sabrigulseven.account.model.Customer;
import com.sabrigulseven.account.model.Transaction;
import com.sabrigulseven.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    account);
            account.getTransaction().add(transaction);
        }

        return accountDtoConverter.convert(accountRepository.save(account));
    }

}
