package com.dictionary.security.service;

import com.dictionary.entities.User;

import com.dictionary.dao.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j

public class UserService implements UserDetailsService {

    private final UserRepo UserRepo;

    @Autowired
    public UserService(UserRepo UserRepo) {
        this.UserRepo = UserRepo;
    }

    public UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        User user = UserRepo.findUserWithNameAndPassword(username, password)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return user;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
