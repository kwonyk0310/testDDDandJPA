package com.example.demo.test.domain.query;

import com.example.demo.test.domain.model.Entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReplyListQueryResult {
  public Integer totalCnt;
  public Integer page;
  public List<Reply> replyList;
}
