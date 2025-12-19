package com.banking.bankingbackend.service;

import com.banking.bankingbackend.dto.TransactionDto;

import java.util.List;

public interface ITransactionService {
    List<TransactionDto> getTransactionsByAccountId(Long accountId);
}
