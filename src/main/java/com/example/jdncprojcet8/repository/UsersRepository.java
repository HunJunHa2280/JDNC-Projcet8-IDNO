package com.example.jdncprojcet8.repository;

import com.example.jdncprojcet8.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository <Users, Long> {
    Optional<Users> findByName(String username);
}