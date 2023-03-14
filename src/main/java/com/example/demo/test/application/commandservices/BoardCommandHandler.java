package com.example.demo.test.application.commandservices;

import com.example.demo.test.domain.model.aggregates.Board;
import com.example.demo.test.domain.model.aggregates.User;
import com.example.demo.test.domain.repository.BoardRepository;
import com.example.demo.test.domain.repository.UserRepository;
import com.example.demo.test.interfaces.board.dto.BoardSaveRqstDto;
import com.example.demo.test.interfaces.user.dto.UserSaveRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardCommandHandler {

  private final BoardRepository boardRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public Board save(BoardSaveRqstDto rqstDto) {

    Board boardInfo = Board.builder()
            .boardTitle(rqstDto.getBoardTitle())
            .boardContent(rqstDto.getBoardContent())
            .build();

    Board board = boardRepository.save(boardInfo);

    logger.info("BoardCommandHandler, save : " + board);
    return board;
  }


  @Transactional
  public Board update(BoardSaveRqstDto rqstDto) {

    Board board = boardRepository.findById(rqstDto.getBoardSeq()).orElseThrow();

    if(board != null) {
      board.changeBoardTitle(rqstDto.getBoardTitle());
      board.changeBoardContent(rqstDto.getBoardContent());
    }
    logger.info("BoardCommandHandler, save : " + board);
    return board;
  }

  @Transactional
  public void delete(BoardSaveRqstDto rqstDto) {

    Board board = boardRepository.findById(rqstDto.getBoardSeq()).orElseThrow();

    if(board != null) {
      boardRepository.delete(board);
    }
    logger.info("BoardCommandHandler, delete success");
  }

}
