package com.onlineshoppy.service.impl;

import com.onlineshoppy.dao.UserRepository;
import com.onlineshoppy.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(usernameOrEmail);

        if (user == null) {
            // If user not found by username, try loading by email
            user = this.userRepository.findByEmail(usernameOrEmail);
        }

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("No user found !!");
        }

        return user;
    }
}
