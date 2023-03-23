package com.example.demo.test.domain.repository;

import java.util.Optional;

import com.example.demo.test.domain.model.entity.AuthDTO;
import com.example.demo.test.domain.model.entity.OperatorDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<OperatorDTO, AuthDTO>{

    @EntityGraph(attributePaths = "authorities")
    Optional<OperatorDTO> findOneWithAuthoritiesByLoginId(String loginId);

}
