package com.example.demo.test.application.queryservices;

import com.example.demo.test.domain.query.UserListQueryResult;
import com.example.demo.test.domain.model.aggregates.User;
import com.example.demo.test.domain.repository.UserRepository;
import com.example.demo.test.interfaces.member.dto.UserListRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserQueryHandler {

  private final UserRepository userRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public UserListQueryResult execute(UserListRqstDto rqstDto) {

    List<User> userList = userRepository.findAll();

    logger.info("UserListQueryHandler, execute : " + userList);

    return UserListQueryResult.builder()
        .totalCnt(userList == null ? 0 : userList.size())
        .page(rqstDto.getPage())
        .userList(userList)
        .build();
  }

}
