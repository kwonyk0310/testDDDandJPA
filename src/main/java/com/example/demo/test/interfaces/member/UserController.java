package com.example.demo.test.interfaces.member;

import com.example.demo.test.application.commandservices.UserCommandHandler;
import com.example.demo.test.application.queryservices.UserQueryHandler;
import com.example.demo.test.domain.model.aggregates.User;
import com.example.demo.test.domain.query.UserListQueryResult;
import com.example.demo.test.interfaces.member.dto.UserListRqstDto;
import com.example.demo.test.interfaces.member.dto.UserSaveRqstDto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {

    private final UserQueryHandler queryHandler;
    private final UserCommandHandler commandHandler;

    @GetMapping( "/list")
    public UserListQueryResult userList(
            @Parameter(in = ParameterIn.QUERY) UserListRqstDto userListRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            UserListQueryResult userList = queryHandler.execute(userListRqstDto);

            return userList;

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @GetMapping( "/insert")
    public User userInsert(
            @Parameter(in = ParameterIn.QUERY) UserSaveRqstDto userSaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            User user = commandHandler.save(userSaveRqstDto);

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    @GetMapping( "/update")
    public User userUpdate(
            @Parameter(in = ParameterIn.QUERY) UserSaveRqstDto userSaveRqstDto
    ) throws Exception{
        log.info("Test Start");

        try {
            User user = commandHandler.update(userSaveRqstDto);

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}