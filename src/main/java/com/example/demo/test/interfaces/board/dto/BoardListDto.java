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
            description = "게시글 제목",
            example = "제목 입니다.",
            required = true
    )
    public String boardTitle;

    @Schema(
            description = "게시글 내용",
            example = "게시글 내용",
            required = true
    )
    private String boardContent;

    @Schema(
            description = "조회수",
            example = "30"
    )
    private Integer views;

    @Schema(
            description = "사용자 고유 번호",
            example = "apple",
            required = true
    )
    private Long userSeq;

    @Schema(
            description = "등록일",
            example = "2023-03-13 12:49:50"
    )
    private LocalDateTime regDate;

    @Schema(
            description = "수정일",
            example = "2023-03-13 12:49:50"
    )
    private LocalDateTime updDate;

}
