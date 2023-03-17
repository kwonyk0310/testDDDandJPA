package com.example.demo.test.domain.repository;

import com.example.demo.test.domain.model.Entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
