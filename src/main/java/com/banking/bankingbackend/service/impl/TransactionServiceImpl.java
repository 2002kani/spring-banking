package com.banking.bankingbackend.service.impl;

import com.banking.bankingbackend.dto.TransactionDto;
import com.banking.bankingbackend.entity.Account;
import com.banking.bankingbackend.entity.Transaction;
import com.banking.bankingbackend.exception.AccountNotFoundException;
import com.banking.bankingbackend.mapper.TransactionMapper;
import com.banking.bankingbackend.repository.IAccountRepository;
import com.banking.bankingbackend.repository.ITransactionRepository;
import com.banking.bankingbackend.service.ITransactionService;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TransactionServiceImpl implements ITransactionService {

    IAccountRepository accountRepository;
    ITransactionRepository transactionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TransactionDto> getTransactionsByAccountId(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException("Account not found");
        }
        List<Transaction> transaction = transactionRepository.findByAccountIdOrderByTimestampDesc(accountId);

        return transaction.stream().map(TransactionMapper::toDto).toList();
    }
}
