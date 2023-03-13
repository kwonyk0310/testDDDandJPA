package com.example.demo.test.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.test.domain.model.aggregates.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
