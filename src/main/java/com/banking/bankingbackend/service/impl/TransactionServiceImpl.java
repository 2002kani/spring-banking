package com.banking.bankingbackend.service.impl;

import com.banking.bankingbackend.dto.TransactionDto;
import com.banking.bankingbackend.entity.Account;
import com.banking.bankingbackend.entity.Transaction;
import com.banking.bankingbackend.exception.AccountNotFoundException;
import com.banking.bankingbackend.mapper.TransactionMapper;
import com.banking.bankingbackend.repository.IAccountRepository;
import com.banking.bankingbackend.repository.ITransactionRepository;
import com.banking.bankingbackend.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements ITransactionService {

    IAccountRepository accountRepository;
    ITransactionRepository transactionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TransactionDto> getTransactionsByAccountId(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException("Account not found");
        }
        List<Transaction> transactions = transactionRepository.findByAccountIdOrderByTimestampDesc(accountId);

        return transactions.stream().map(TransactionMapper::toDto).toList();
    }

    @Override
    public TransactionDto getTransactionByTransactionId(Long accountId, Long transactionId) {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException("Account not found");
        }

        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);

        if(!transaction.getAccount().getId().equals(accountId)) {
            throw new RuntimeException("Transaction does not belong to account");
        }

        return TransactionMapper.toDto(transaction);
    }
}
