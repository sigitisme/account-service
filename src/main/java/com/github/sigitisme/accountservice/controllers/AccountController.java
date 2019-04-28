package com.github.sigitisme.accountservice.controllers;

import com.github.sigitisme.accountservice.controllers.exceptions.NotFoundException;
import com.github.sigitisme.accountservice.data.model.Account;
import com.github.sigitisme.accountservice.data.services.AccountService;
import com.github.sigitisme.accountservice.dto.AccountDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/accounts")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable("id") Long id) throws NotFoundException {

        LOGGER.info("[GET] /v1/accounts/{id}");

        Account account = accountService.findById(id).orElse(null);

        if(account == null) throw NotFoundException.sendException("Not Found! Account with id: " + id + " not found");

        AccountDTO dto = modelMapper.map(account, AccountDTO.class);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() throws NotFoundException{
        LOGGER.info("[GET] /v1/accounts/");

        List<Account> list = accountService.findAll();

        if(list.size() == 0) throw NotFoundException.sendException("Not Found! Accounts are empty!");

        List<AccountDTO> listDto = list
                .stream()
                .map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listDto);
    }
}
