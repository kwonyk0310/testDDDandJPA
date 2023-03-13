package com.example.demo.test.interfaces.user.validation;

import com.example.demo.test.interfaces.user.dto.UserListRqstDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserListRqstDtoValidation.Validator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserListRqstDtoValidation {

  String message() default "Invalid UserListRqstDto";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Slf4j
  @RequiredArgsConstructor
  class Validator implements ConstraintValidator<UserListRqstDtoValidation, UserListRqstDto> {

    @Override
    public void initialize(UserListRqstDtoValidation constraintAnnotation) {
      ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserListRqstDto value, ConstraintValidatorContext context) {

      if (value.getPage() == null || value.getSearchType() == null || value.getPagingSize() == null) {

        log.error("입력 파라미터가 부족합니다. (getPage, getSearchType, getPagingSize) - {}",
            value);
        return false;
      }

      if ("P".equals(value.getSearchType())
          && (value.getStartDt() == null || value.getEndDt() == null)) {
        log.error("입력 파라미터가 부족합니다. (검색타입이 P인데, 시작일 종료일 데이터가 없습니다.) - {}", value);
        return false;
      }

      if (value.getPagingSize() < 5 || value.getPagingSize() > 100) {
        log.error("유효하지 않은 파라미터 값입니다.(pagingSize 범위 초과 5~100 사이) - {}", value);
        return false;
      }

      return true;
    }
  }
}
