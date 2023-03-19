package com.example.demo.test.interfaces.user.dto;

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
//@StickerSendRqstDtoValidation
public class UserSaveRqstDto {

  @Schema(
      description = "사용자 고유 번호",
      example = "1",
      required = true
  )
  private Long userSeq;

  @Schema(
      description = "사용자 아이디",
      example = "apple",
      required = true
  )
  private String userId;

  @Schema(
      description = "사용자 이름",
      example = "포도",
      required = true
  )
  private String userName;

  @Schema(
      description = "나이",
      example = "30",
      required = true
  )
  private Integer age;

  @Schema(
      description = "성별",
      example = "W",
      required = true
  )
  private String gender;

}
