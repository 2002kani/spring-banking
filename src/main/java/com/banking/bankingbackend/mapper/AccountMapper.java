package com.banking.bankingbackend.mapper;

import com.banking.bankingbackend.dto.AccountDto;
import com.banking.bankingbackend.entity.Account;

public class AccountMapper {
    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getOwnerName(),
                account.getBalance(),
                account.getCreatedAt()
        );
    }

    public static Account mapToAccount(AccountDto dto) {
        return Account.builder()
                .id(dto.getId())
                .ownerName(dto.getOwnerName())
                .balance(dto.getBalance())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
