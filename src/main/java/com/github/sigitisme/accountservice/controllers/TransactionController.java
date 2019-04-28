package com.github.sigitisme.accountservice.controllers;

import com.github.sigitisme.accountservice.controllers.exceptions.NotFoundException;
import com.github.sigitisme.accountservice.data.model.Transaction;
import com.github.sigitisme.accountservice.data.services.TransactionService;
import com.github.sigitisme.accountservice.dto.TransactionDTO;
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
@RequestMapping(value = "/v1/transactions")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable("id") Long id) throws NotFoundException {
        LOGGER.info("[GET] /v1/transactions/{id}");

        Transaction transaction = transactionService.findById(id).orElse(null);

        if(transaction == null) throw NotFoundException.sendException("Not Found! Transaction with id " + id + " not found.");

        TransactionDTO dto = modelMapper.map(transaction, TransactionDTO.class);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() throws NotFoundException{

        LOGGER.info("[GET] /v1/transactions/");

        List<Transaction> list = transactionService.findAll();

        if(list.size() == 0) throw NotFoundException.sendException("Not Found! Transaction log is empty");

        List<TransactionDTO> listDto = list
                .stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listDto);
    }


}
