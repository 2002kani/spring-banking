package com.banking.bankingbackend.mapper;

import com.banking.bankingbackend.dto.TransactionDto;
import com.banking.bankingbackend.entity.Transaction;

public class TransactionMapper {
    public static TransactionDto toDto(Transaction transaction) {
        if (transaction == null) return null;

        return new TransactionDto(
                transaction.getId(),
                transaction.getAccount() != null ? transaction.getAccount().getId() : null,
                transaction.getType() != null ? transaction.getType().name() : null,
                transaction.getAmount(),
                transaction.getTimestamp()
        );
    }

    public static Transaction toEntity(TransactionDto dto, com.banking.bankingbackend.entity.Account account) {
        if (dto == null) return null;

        return Transaction.builder()
                .id(dto.getId()) // optional: weglassen beim Erstellen neuer Transaktionen
                .account(account) // Account muss als Entity übergeben werden
                .type(dto.getType() != null ? com.banking.bankingbackend.enums.TransactionType.valueOf(dto.getType()) : null)
                .amount(dto.getAmount())
                .timestamp(dto.getTimestamp())
                .build();
    }
}
