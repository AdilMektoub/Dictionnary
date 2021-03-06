package com.dictionary.security.service.security;

import com.dictionary.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    UserService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;

        String name = auth.getName();
        System.out.println(name);
        String password = auth.getCredentials()
                .toString();
        
        System.out.println(password);

        UserDetails user = userDetailsService.loadUserByUsername(name , password);

        if (user == null) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }

        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;

    }
}
