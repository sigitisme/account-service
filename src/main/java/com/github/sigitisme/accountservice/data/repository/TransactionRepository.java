package com.github.sigitisme.accountservice.data.repository;

import com.github.sigitisme.accountservice.data.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
