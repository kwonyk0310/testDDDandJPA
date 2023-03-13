package com.example.demo.test.interfaces.member.mapper;

import com.example.demo.test.domain.query.UserListQuery;
import com.example.demo.test.interfaces.member.dto.UserListRqstDto;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Slf4j
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserListRqstMapper {

    UserListRqstMapper INSTANCE = Mappers.getMapper(UserListRqstMapper.class);

  public abstract UserListQuery of(UserListRqstDto rqstDto);

}
