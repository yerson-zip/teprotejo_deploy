package com.teprotejo.mapper;

import com.teprotejo.dto.EmergencyDto;
import com.teprotejo.entity.Emergency;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-07T09:33:14-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class EmergencyMapperImpl implements EmergencyMapper {

    @Override
    public Emergency emergency(EmergencyDto emergencyDto) {
        if ( emergencyDto == null ) {
            return null;
        }

        Emergency emergency = new Emergency();

        emergency.setLatitude( emergencyDto.getLatitude() );
        emergency.setLongitude( emergencyDto.getLongitude() );
        emergency.setDateTime( emergencyDto.getDateTime() );
        emergency.setCity( emergencyDto.getCity() );

        return emergency;
    }
}
