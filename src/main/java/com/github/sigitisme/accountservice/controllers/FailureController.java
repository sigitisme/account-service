package com.github.sigitisme.accountservice.controllers;

import com.github.sigitisme.accountservice.controllers.exceptions.NotFoundException;
import com.github.sigitisme.accountservice.data.model.Failure;
import com.github.sigitisme.accountservice.data.services.FailureService;
import com.github.sigitisme.accountservice.dto.FailureDTO;
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
@RequestMapping(value = "/v1/failures")
public class FailureController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FailureController.class);

    @Autowired
    private FailureService failureService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "{id}")
    public ResponseEntity<FailureDTO> getFailure(@PathVariable("id") Long id) throws NotFoundException {

        LOGGER.info("[GET] /v1/failures/{id}");

        Failure failure = failureService.findById(id).orElse(null);

        if(failure == null) throw NotFoundException.sendException("Not Found! Failure with id : " + id + " not found.");

        FailureDTO dto = modelMapper.map(failure, FailureDTO.class);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<FailureDTO>> getAllFailures() throws NotFoundException{
        LOGGER.info("[GET] /v1/failures/");

        List<Failure> list = failureService.findAll();

        if(list.size() == 0) throw NotFoundException.sendException("Not Found! Failure log is empty");

        List<FailureDTO> listDto = list
                .stream()
                .map(failure -> modelMapper.map(failure, FailureDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listDto);
    }
}
