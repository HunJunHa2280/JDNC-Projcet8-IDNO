package com.example.jdncprojcet8.security;

import com.example.jdncprojcet8.entity.Users;
import com.example.jdncprojcet8.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users users = userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + name));

        return new UserDetailsImpl(users);
    }
}