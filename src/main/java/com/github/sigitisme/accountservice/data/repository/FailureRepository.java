package com.github.sigitisme.accountservice.data.repository;

import com.github.sigitisme.accountservice.data.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailureRepository extends JpaRepository<Failure, Long> {
}
