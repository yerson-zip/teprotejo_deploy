package com.teprotejo.mapper;

import com.teprotejo.dto.EmergencyDto;
import com.teprotejo.entity.Emergency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmergencyMapper {

    Emergency emergency(EmergencyDto emergencyDto);

}
