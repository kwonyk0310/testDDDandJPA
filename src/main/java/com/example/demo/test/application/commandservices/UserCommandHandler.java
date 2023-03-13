package com.example.demo.test.application.commandservices;

import com.example.demo.test.domain.model.aggregates.User;
import com.example.demo.test.domain.query.UserListQueryResult;
import com.example.demo.test.domain.repository.UserRepository;
import com.example.demo.test.interfaces.member.dto.UserListRqstDto;
import com.example.demo.test.interfaces.member.dto.UserSaveRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCommandHandler {

  private final UserRepository userRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public User save(UserSaveRqstDto rqstDto) {

    User userInfo = User.builder()
            .age(rqstDto.getAge())
            .userId(rqstDto.getUserId())
            .gender(rqstDto.getGender())
            .userName(rqstDto.getUserName())
            .build();

    User user = userRepository.save(userInfo);

    logger.info("UserCommandHandler, save : " + user);
    return user;
  }


  @Transactional
  public User update(UserSaveRqstDto rqstDto) {

    User user = userRepository.findById(rqstDto.getUserSeq()).orElseThrow();

    if(user != null) {
      user.changeUserName(rqstDto.getUserName());
    }
    logger.info("UserCommandHandler, save : " + user);
    return user;
  }

  @Transactional
  public void delete(UserSaveRqstDto rqstDto) {

    User user = userRepository.findById(rqstDto.getUserSeq()).orElseThrow();

    if(user != null) {
      userRepository.delete(user);
    }
    logger.info("UserCommandHandler, delete success");
  }

}
