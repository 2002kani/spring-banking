package com.banking.bankingbackend.service;

import com.banking.bankingbackend.dto.AccountDto;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {
    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(Long id);
    AccountDto createAccount(AccountDto accountDto);
    AccountDto deposit(Long id, BigDecimal amount);
    AccountDto withdraw(Long id, BigDecimal amount);
}
