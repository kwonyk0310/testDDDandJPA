package com.example.demo.test.interfaces.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardListDto {

    @Schema(
            description = "게시글 고유번호",
            example = "151",
            required = true
    )
    public int boardSeq;

    @Schema(
            description = "사용자 이름",
            example = "권연경",
            required = true
    )
    public String boardTitle;

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
            description = "등록일",
            example = "2023.03.01",
            required = true
    )
    public LocalDateTime regDate;

}
