package com.example.demo.test.interfaces.board;

import com.example.demo.test.application.commandservices.BoardCommandHandler;
import com.example.demo.test.application.queryservices.BoardQueryHandler;
import com.example.demo.test.domain.model.aggregates.Board;
import com.example.demo.test.domain.query.BoardListQueryResult;
import com.example.demo.test.interfaces.board.dto.BoardListRqstDto;
import com.example.demo.test.interfaces.board.dto.BoardSaveRqstDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/Board")
public class BoardController {

    private final BoardQueryHandler queryHandler;
    private final BoardCommandHandler commandHandler;

    @GetMapping( "/list")
    public BoardListQueryResult boardList(
            @Parameter(in = ParameterIn.QUERY) BoardListRqstDto boardListRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            BoardListQueryResult boardList = queryHandler.execute(boardListRqstDto);

            return boardList;

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @PostMapping( "/insert")
    public Board boardInsert(
            @Parameter(in = ParameterIn.QUERY) BoardSaveRqstDto boardSaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            Board board = commandHandler.save(boardSaveRqstDto);

            return board;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @PostMapping( "/update")
    public Board boardUpdate(
            @Parameter(in = ParameterIn.QUERY) BoardSaveRqstDto boardSaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            Board board = commandHandler.update(boardSaveRqstDto);

            return board;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @PostMapping( "/delete")
    public void boardDelete(
            @Parameter(in = ParameterIn.QUERY) BoardSaveRqstDto boardSaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            commandHandler.delete(boardSaveRqstDto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}