package com.banking.bankingbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner_name",  nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
