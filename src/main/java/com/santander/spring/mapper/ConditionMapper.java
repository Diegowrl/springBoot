package com.santander.spring.mapper;

import com.santander.spring.dto.ConditionDTO;
import com.santander.spring.entities.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConditionMapper {
    ConditionMapper INSTANCE = Mappers.getMapper(ConditionMapper.class);
    ConditionDTO mapToDto(Condition condition);

}
