package com.example.demo.test.application.commandservices;

import com.example.demo.test.domain.model.aggregates.Board;
import com.example.demo.test.domain.model.entity.Reply;
import com.example.demo.test.domain.repository.BoardRepository;
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
  private final BoardRepository boardRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Reply save(ReplySaveRqstDto rqstDto) {

    Board board = boardRepository.findById(rqstDto.getBoardSeq()).orElseThrow(
        ()->new IllegalArgumentException("해당하는 게시글이 없습니다."));

    Reply replyInfo = Reply.builder()
            .replyContent(rqstDto.getReplyContent())
            .userSeq(rqstDto.getUserSeq())
            .board(board)
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
