package com.teprotejo.mapper;

import com.teprotejo.dto.CAIDto;
import com.teprotejo.entity.CAI;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CAIMapper{


    CAI caiDtoToCai(CAIDto caiDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCai(CAIDto caiDto, @MappingTarget CAI cai);


}
