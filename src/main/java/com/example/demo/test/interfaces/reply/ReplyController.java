package com.example.demo.test.interfaces.reply;

import com.example.demo.test.application.queryservices.ReplyQueryHandler;
import com.example.demo.test.domain.query.ReplyListQueryResult;
import com.example.demo.test.interfaces.reply.dto.ReplyListRqstDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/Reply")
public class ReplyController {

    private final ReplyQueryHandler queryHandler;
//    private final ReplyCommandHandler commandHandler;

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

//    @GetMapping( "/insert")
//    public Reply replyInsert(
//            @Parameter(in = ParameterIn.QUERY) ReplySaveRqstDto replySaveRqstDto
//    ) throws Exception{
//        log.info("Test Start");
//
//        try {
//            Reply reply = commandHandler.save(replySaveRqstDto);
//
//            return reply;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }
//
//    @GetMapping( "/update")
//    public Reply replyUpdate(
//            @Parameter(in = ParameterIn.QUERY) ReplySaveRqstDto replySaveRqstDto
//    ) throws Exception{
//        log.info("Test Start");
//
//        try {
//            Reply reply = commandHandler.update(replySaveRqstDto);
//
//            return reply;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }
//
//    @GetMapping( "/delete")
//    public void replyDelete(
//            @Parameter(in = ParameterIn.QUERY) ReplySaveRqstDto replySaveRqstDto
//    ) throws Exception{
//        log.info("Test Start");
//
//        try {
//            commandHandler.delete(replySaveRqstDto);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception();
//        }
//    }

}