package com.example.demo.test.application.commandservices;

import com.example.demo.test.domain.model.Entity.Reply;
import com.example.demo.test.domain.repository.ReplyRepository;
import com.example.demo.test.interfaces.reply.dto.ReplySaveRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyCommandHandler {

  private final ReplyRepository replyRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Reply save(ReplySaveRqstDto rqstDto) {

    Reply replyInfo = Reply.builder()
            .replyContent(rqstDto.getReplyContent())
            .userSeq(rqstDto.getUserSeq())
            .boardSeq(rqstDto.getBoardSeq())
            .build();

    Reply reply = replyRepository.save(replyInfo);

    logger.info("ReplyCommandHandler, save : " + reply);
    return reply;
  }


  @Transactional
  public Reply update(ReplySaveRqstDto rqstDto) {

    Reply reply = replyRepository.findById(rqstDto.getReplySeq()).orElseThrow();

    if(reply != null) {
      reply.changeReplyContent(rqstDto.getReplyContent());
      reply.updateUpdDate();
    }
    logger.info("ReplyCommandHandler, save : " + reply);
    return reply;
  }

  @Transactional
  public void delete(ReplySaveRqstDto rqstDto) {

    Reply reply = replyRepository.findById(rqstDto.getReplySeq()).orElseThrow();

    if(reply != null) {
      replyRepository.delete(reply);
    }
    logger.info("ReplyCommandHandler, delete success");
  }

}
