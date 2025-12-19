package com.banking.bankingbackend.controller;

import com.banking.bankingbackend.dto.AccountDto;
import com.banking.bankingbackend.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts() {
        List<AccountDto> dtos = accountService.getAllAccounts();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
        AccountDto dto = accountService.getAccountById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestParam BigDecimal amount) {
        AccountDto patchedAccount = accountService.deposit(id, amount);
        return ResponseEntity.ok(patchedAccount);
    }

    @PatchMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestParam BigDecimal amount) {
        AccountDto patchedAccount = accountService.withdraw(id, amount);
        return ResponseEntity.ok(patchedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id) {
        BigDecimal balance = accountService.getAccountBalance(id);
        return ResponseEntity.ok(balance);
    }
}
