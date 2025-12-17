package com.banking.bankingbackend.service.impl;

import com.banking.bankingbackend.dto.AccountDto;
import com.banking.bankingbackend.entity.Account;
import com.banking.bankingbackend.exception.AccountNotFoundException;
import com.banking.bankingbackend.exception.InsufficientFundException;
import com.banking.bankingbackend.mapper.AccountMapper;
import com.banking.bankingbackend.repository.IAccountRepository;
import com.banking.bankingbackend.service.IAccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
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
    @Transactional
    public AccountDto deposit(Long id, BigDecimal amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        account.setBalance(account.getBalance().add(amount));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    @Transactional
    public AccountDto withdraw(Long id, BigDecimal amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        if(account.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            throw new InsufficientFundException("Not enough balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        return AccountMapper.mapToAccountDto(account);
    }
}
