package com.example.demo.test.interfaces.board.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter // @Validated 사용을 위해선 @Setter가 필수
@AllArgsConstructor
@ToString
public class BoardSaveRqstDto {

  @Schema(
      description = "게시글 고유 번호",
      example = "1",
      required = true
  )
  private Long boardSeq;

  @Schema(
      description = "게시글 제목",
      example = "게시글 제목",
      required = true
  )
  private String boardTitle;

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
