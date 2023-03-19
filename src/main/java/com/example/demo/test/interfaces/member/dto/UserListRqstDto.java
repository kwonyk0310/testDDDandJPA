package com.example.demo.test.interfaces.member.dto;

import com.example.demo.test.interfaces.member.validation.UserListRqstDtoValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@UserListRqstDtoValidation
public class UserListRqstDto {

    private String userId;
    @Schema(
            description = "조회 타입",
            example = "W",
            maxLength = 1
    )
    private String searchType;

    @Schema(
            description = "조회 시작일자",
            example = "2022-06-27",
            maxLength = 10
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDt;

    @Schema(
            description = "조회 종료일자",
            example = "2022-06-27",
            maxLength = 10
    )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDt;

    @Schema(
            description = "페이징사이즈",
            example = "5",
            required = true
    )
    private Integer pagingSize;

    @Schema(
            description = "조회페이지",
            example = "1",
            required = true
    )
    private Integer page;

}
