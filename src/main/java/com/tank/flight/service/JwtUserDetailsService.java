package com.tank.flight.service;

import com.tank.flight.entity.User;
import com.tank.flight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
  @Autowired private UserRepository userRepository;
  String ROLE_PREFIX = "ROLE_";
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUserName(username);
    System.out.println(user);

    if (user == null) {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole());
    return new org.springframework.security.core.userdetails.User(
            user.getUserName(), user.getPassWord(), new ArrayList<>(List.of(authority))
    );
  }
}
