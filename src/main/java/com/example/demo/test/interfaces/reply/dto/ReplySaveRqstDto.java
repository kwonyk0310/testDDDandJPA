package com.example.demo.test.interfaces.reply.dto;

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
public class ReplySaveRqstDto {

  @Schema(
          description = "게시글 고유번호",
          example = "151",
          required = true
  )
  public Long replySeq;

  @Schema(
          description = "댓글 내용",
          example = "댓글 내용 입니다.",
          required = true
  )
  private String replyContent;

  @Schema(
          description = "사용자 고유 번호",
          example = "4",
          required = true
  )
  private Long userSeq;

  @Schema(
          description = "게시글 고유 번호",
          example = "apple",
          required = true
  )
  private Long boardSeq;



}
