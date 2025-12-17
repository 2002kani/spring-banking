package com.banking.bankingbackend.controller;

import com.banking.bankingbackend.dto.AccountDto;
import com.banking.bankingbackend.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/account")
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
}
