//package com.example.demo.test.interfaces.member.mapper;
//
//import kr.co.starbucks.config.MapstructConfig;
//import kr.co.starbucks.frequency.domain.model.aggregates.admin.FreqInfo;
//import kr.co.starbucks.frequency.domain.query.PromoListQueryResult;
//import kr.co.starbucks.frequency.interfaces.freqapp.rest.dto.PromoListDto;
//import kr.co.starbucks.frequency.interfaces.freqapp.rest.dto.PromoListRspDto;
//import kr.co.starbucks.libs.utils.DateMapperUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.mapstruct.IterableMapping;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//
//import java.util.List;
//
//@Slf4j
//@Mapper(config = MapstructConfig.class, uses = DateMapperUtil.class)
//public abstract class UserListRspDtoMapper {
//
//  @Named("defaultE2D")
//  @Mapping(target = "freqType", source = "efrqnTypeCode")
//  @Mapping(target = "promoSeq", source = "freqInfoId.freqInfoSeq")
//  @Mapping(target = "promoTitle", source = "freqTitle")
//  @Mapping(target = "promoStartDt", expression = "java(promotion.getGiveStartDate().atStartOfDay())")
//  @Mapping(target = "promoEndDt", expression = "java(promotion.getGiveEndDate().atTime(23, 59, 59))")
//  @Mapping(target = "changeStartDt", expression = "java(promotion.getUseStartDate().atStartOfDay())")
//  @Mapping(target = "changeEndDt", expression = "java(promotion.getUseEndDate().atTime(23, 59, 59))")
//  @Mapping(target = "promoIntroUrl", source = "promDtlUrl")
//  @Mapping(target = "promoExpiredYn", ignore = true)
//  public abstract PromoListDto entityToDto(FreqInfo promotion);
//
//  @IterableMapping(qualifiedByName = "defaultE2D")
//  public abstract List<PromoListDto> mapList(List<FreqInfo> promotionList);
//
//  public PromoListRspDto of(PromoListQueryResult result) {
//    return new PromoListRspDto(result.getTotalCnt(), result.getPage(),
//        mapList(result.getPromotionList()));
//  }
//}
