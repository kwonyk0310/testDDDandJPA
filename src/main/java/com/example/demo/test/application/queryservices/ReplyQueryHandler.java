package com.example.demo.test.application.queryservices;

import com.example.demo.test.domain.model.Entity.Reply;
import com.example.demo.test.domain.query.ReplyListQueryResult;
import com.example.demo.test.domain.repository.ReplyRepository;
import com.example.demo.test.interfaces.reply.dto.ReplyListRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyQueryHandler {

  private final ReplyRepository replyRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public ReplyListQueryResult execute(ReplyListRqstDto rqstDto) {

    List<Reply> replyList = replyRepository.findAll();

    logger.info("ReplyListQueryHandler, execute : " + replyList);

    return ReplyListQueryResult.builder()
        .totalCnt(replyList == null ? 0 : replyList.size())
        .page(rqstDto.getPage())
        .replyList(replyList)
        .build();
  }

}
