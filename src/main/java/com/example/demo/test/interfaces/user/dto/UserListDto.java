package com.example.demo.test.interfaces.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserListDto {

    @Schema(
            description = "사용자 일련번호",
            example = "151",
            required = true
    )
    public int userSeq;

    @Schema(
            description = "사용자 이름",
            example = "권연경",
            required = true
    )
    public String userName;

    @Schema(
            description = "나이",
            example = "30",
            required = true
    )
    public int age;

    @Schema(
            description = "성별",
            example = "W",
            required = true
    )
    public String gender;

    @Schema(
            description = "사용자 아이디",
            example = "ykkwon",
            required = true
    )
    public String userId;

    @Schema(
            description = "가입일",
            example = "2015.04.01",
            required = true
    )
    public LocalDateTime registrationDate;

}
