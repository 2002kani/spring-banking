package com.banking.bankingbackend.repository;

import com.banking.bankingbackend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
