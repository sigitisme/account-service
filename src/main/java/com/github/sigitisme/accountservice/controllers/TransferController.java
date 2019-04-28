package com.github.sigitisme.accountservice.controllers;

import com.github.sigitisme.accountservice.data.services.TransferService;
import com.github.sigitisme.accountservice.dto.BaseResponse;
import com.github.sigitisme.accountservice.dto.TransferReqBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class TransferController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    private TransferService transferService;

    @PostMapping(value = "transfer")
    public BaseResponse transfer(@RequestBody TransferReqBody transferReqBody){
        LOGGER.info("[POST] /v1/transfer");

        return transferService.transfer(transferReqBody);
    }

    @PostMapping(value = "void-transfer")
    public void voidTransfer(@RequestBody TransferReqBody transferReqBody){
        LOGGER.info("[POST] /v1/void-transfer");

        transferService.transfer(transferReqBody);
    }

}
