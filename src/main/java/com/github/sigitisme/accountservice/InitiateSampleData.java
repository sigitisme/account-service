package com.github.sigitisme.accountservice;

import com.github.sigitisme.accountservice.data.model.Account;
import com.github.sigitisme.accountservice.data.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitiateSampleData  implements CommandLineRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        //initialize db

		Account account1 = new Account("0012345678", "Eko", 1000, 1);
		Account account2 = new Account("0012345688", "Akri", 2000, 1);
		Account account3 = new Account("0012345699", "Parto", 2000, 0);

		accountService.save(account1);
		accountService.save(account2);
		accountService.save(account3);
    }
}
