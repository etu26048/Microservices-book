package com.multiplication.multiplication.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.multiplication.multiplication.domain.User;

/**
 * This interface allows us to save and retrieve Users
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAlias(final String alias);

}
