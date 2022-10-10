package com.kms.training.trainingproject.service;

import com.kms.training.trainingproject.entity.UserEntity;
import com.kms.training.trainingproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserEntityByUserName(userName);
        if (userEntity != null) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            return new org.springframework.security.core.userdetails.User(userEntity.getUserName(), userEntity.getPassword(), authorities);
        }
        if (userEntity == null) {
            throw new UsernameNotFoundException("Can not find userName:" + userName + " in the database");
        } else {
            throw new RuntimeException();
        }
    }

}