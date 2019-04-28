package com.github.sigitisme.accountservice.data.services;

import com.github.sigitisme.accountservice.data.model.Failure;
import com.github.sigitisme.accountservice.data.repository.FailureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FailureService implements CrudService<Failure> {

    @Autowired
    private FailureRepository failureRepository;

    @Override
    public List<Failure> findAll() {
        return failureRepository.findAll();
    }

    @Override
    public Optional<Failure> findById(Long id) {
        return failureRepository.findById(id);
    }

    @Override
    public Failure save(Failure failure) {
        return failureRepository.save(failure);
    }
}
