package com.banking.bankingbackend.controller;

import com.banking.bankingbackend.dto.TransactionDto;
import com.banking.bankingbackend.enums.TransactionType;
import com.banking.bankingbackend.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class TransactionController {

    ITransactionService transactionService;

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactionsByAccountId(@PathVariable Long accountId, @RequestParam(required = false) TransactionType type) {

        if(type == null){
            List<TransactionDto> transactions = transactionService.getTransactionsByAccountId(accountId);
            return ResponseEntity.ok(transactions);
        }

        List<TransactionDto> transactions = transactionService.getTransactionByTransactionType(accountId, type);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{accountId}/transaction/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long accountId, @PathVariable Long transactionId) {
        TransactionDto transaction = transactionService.getTransactionByTransactionId(accountId, transactionId);
        return ResponseEntity.ok(transaction);
    }
}
