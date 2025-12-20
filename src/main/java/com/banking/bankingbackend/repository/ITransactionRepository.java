package com.banking.bankingbackend.repository;

import com.banking.bankingbackend.entity.Transaction;
import com.banking.bankingbackend.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountIdOrderByTimestampDesc(Long accountId);
    List<Transaction> findByAccountIdAndType(Long accountId, TransactionType type);
}
