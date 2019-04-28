package com.github.sigitisme.accountservice.data.repository;

import com.github.sigitisme.accountservice.data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAcctNo(String acctNo);
}
