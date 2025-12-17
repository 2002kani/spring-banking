package com.banking.bankingbackend.service.impl;

import com.banking.bankingbackend.dto.AccountDto;
import com.banking.bankingbackend.entity.Account;
import com.banking.bankingbackend.mapper.AccountMapper;
import com.banking.bankingbackend.repository.IAccountRepository;
import com.banking.bankingbackend.service.IAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    IAccountRepository accountRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto)
                .toList();
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElse(null);

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto deposit(Long id, BigDecimal amount) {
        return null;
    }

    @Override
    public AccountDto withdraw(Long id, BigDecimal amount) {
        return null;
    }
}
