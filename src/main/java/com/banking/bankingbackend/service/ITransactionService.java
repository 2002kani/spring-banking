package com.banking.bankingbackend.service;

import com.banking.bankingbackend.dto.TransactionDto;
import com.banking.bankingbackend.enums.TransactionType;

import java.util.List;

public interface ITransactionService {
    List<TransactionDto> getTransactionsByAccountId(Long accountId);
    TransactionDto getTransactionByTransactionId(Long accountId, Long transactionId);
    List<TransactionDto> getTransactionByTransactionType(Long accountId, TransactionType type);
}
