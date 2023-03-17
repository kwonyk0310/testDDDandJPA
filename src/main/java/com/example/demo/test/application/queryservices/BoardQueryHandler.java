package com.example.demo.test.application.queryservices;

import com.example.demo.test.domain.model.aggregates.Board;
import com.example.demo.test.domain.query.BoardListQueryResult;
import com.example.demo.test.domain.repository.BoardRepository;
import com.example.demo.test.interfaces.board.dto.BoardListRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardQueryHandler {

  private final BoardRepository boardRepository;

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public BoardListQueryResult execute(BoardListRqstDto rqstDto) {

    List<Board> boardList = boardRepository.findAll();

    logger.info("BoardListQueryHandler, execute : " + boardList);

    return BoardListQueryResult.builder()
        .totalCnt(boardList == null ? 0 : boardList.size())
        .page(rqstDto.getPage())
        .boardList(boardList)
        .build();
  }

}
