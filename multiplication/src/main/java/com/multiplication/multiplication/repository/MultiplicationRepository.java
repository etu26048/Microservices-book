package com.multiplication.multiplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multiplication.multiplication.domain.Multiplication;

/**
 * This interface allows us to save and retrieve Multiplications
 */
@Repository
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
