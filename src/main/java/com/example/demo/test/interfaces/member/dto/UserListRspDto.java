package com.example.demo.test.interfaces.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserListRspDto {

    @Schema(
            description = "총건수",
            example = "2",
            required = true
    )
    private int totalCnt;

    @Schema(
            description = "조회페이지",
            example = "1",
            required = true
    )
    private int page;

    @Schema(
            description = "회원 목록",
            example = "{}",
            required = true
    )
    private List<UserListDto> memberList;


}
