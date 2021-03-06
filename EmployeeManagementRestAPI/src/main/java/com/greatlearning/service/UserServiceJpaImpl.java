package com.greatlearning.service;

import com.greatlearning.dao.UserDao;
import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceJpaImpl implements UserService {

    @Autowired
    PasswordEncoderService passwordEncoder;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.getPasswordEncoder().encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
