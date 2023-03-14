package com.example.demo.test.domain.query;

import com.example.demo.test.domain.model.aggregates.Board;
import com.example.demo.test.domain.model.aggregates.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BoardListQueryResult {
  public Integer totalCnt;
  public Integer page;
  public List<Board> boardList;
}
