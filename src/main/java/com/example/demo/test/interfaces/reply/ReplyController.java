package com.example.demo.test.interfaces.reply;

import com.example.demo.test.application.commandservices.ReplyCommandHandler;
import com.example.demo.test.application.queryservices.BoardQueryHandler;
import com.example.demo.test.application.queryservices.ReplyQueryHandler;
import com.example.demo.test.domain.model.aggregates.Board;
import com.example.demo.test.domain.model.entity.Reply;
import com.example.demo.test.domain.query.ReplyListQueryResult;
import com.example.demo.test.interfaces.reply.dto.ReplyListRqstDto;
import com.example.demo.test.interfaces.reply.dto.ReplySaveRqstDto;
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
    @RequestMapping("/Reply")
public class ReplyController {

    private final ReplyQueryHandler queryHandler;
//    private final BoardQueryHandler boardQueryHandler;
    private final ReplyCommandHandler commandHandler;

    @GetMapping( "/list")
    public ReplyListQueryResult replyList(
            @Parameter(in = ParameterIn.QUERY) ReplyListRqstDto replyListRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            ReplyListQueryResult replyList = queryHandler.execute(replyListRqstDto);

            return replyList;

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @PostMapping( "/insert")
    public Reply replyInsert(
            @Parameter(in = ParameterIn.QUERY) ReplySaveRqstDto replySaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
//            Board board = boardQueryHandler.findById(rqstDto.getBoardSeq()).orElseThrow(
//                ()->new IllegalArgumentException("해당하는 게시글이 없습니다."));
            Reply reply = commandHandler.save(replySaveRqstDto);

            return reply;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @PostMapping( "/update")
    public Reply replyUpdate(
            @Parameter(in = ParameterIn.QUERY) ReplySaveRqstDto replySaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            Reply reply = commandHandler.update(replySaveRqstDto);

            return reply;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @PostMapping( "/delete")
    public void replyDelete(
            @Parameter(in = ParameterIn.QUERY) ReplySaveRqstDto replySaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            commandHandler.delete(replySaveRqstDto);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}