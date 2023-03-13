package com.example.demo.test.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import com.example.demo.test.domain.model.aggregates.User;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserListQueryResult {
  public Integer totalCnt;
  public Integer page;
  public List<User> userList;
}
