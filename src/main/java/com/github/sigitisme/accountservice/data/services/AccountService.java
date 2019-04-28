package com.github.sigitisme.accountservice.data.services;

import com.github.sigitisme.accountservice.data.model.Account;
import com.github.sigitisme.accountservice.data.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements CrudService<Account> {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> findByAcctNo(String acctNo){
        return accountRepository.findByAcctNo(acctNo);
    }

}
