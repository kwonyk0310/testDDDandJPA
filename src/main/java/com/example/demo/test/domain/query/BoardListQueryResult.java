package com.example.demo.test.domain.query;

import com.example.demo.test.domain.model.aggregates.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class BoardListQueryResult {
  public Integer totalCnt;
  public Integer page;
  public List<Board> boardList;
}
