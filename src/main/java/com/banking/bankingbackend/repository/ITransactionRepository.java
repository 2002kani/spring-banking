package com.banking.bankingbackend.repository;

import com.banking.bankingbackend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
}
