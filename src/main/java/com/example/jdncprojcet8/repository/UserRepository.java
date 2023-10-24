package com.example.jdncprojcet8.repository;

import com.example.jdncprojcet8.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
