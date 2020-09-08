package com.dictionary.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dictionary.entities.User;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long> {
	
    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);
    
    @Query(" select u from User u " +
            " where u.username = ?1 and u.password = ?2")
    Optional<User> findUserWithNameAndPassword(String username, String password);

}
