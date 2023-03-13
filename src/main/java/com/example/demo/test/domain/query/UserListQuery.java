package com.example.demo.test.domain.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserListQuery {

  private final String userId;
  private final String searchType;
  private final LocalDate startDt;
  private final LocalDate endDt;
  private final int pagingSize;
  private final int page;
}

