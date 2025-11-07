package com.teprotejo.mapper;

import com.teprotejo.dto.CAIDto;
import com.teprotejo.entity.CAI;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-07T09:33:13-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class CAIMapperImpl implements CAIMapper {

    @Override
    public CAI caiDtoToCai(CAIDto caiDto) {
        if ( caiDto == null ) {
            return null;
        }

        CAI cAI = new CAI();

        cAI.setStation_name( caiDto.getStation_name() );
        cAI.setTelephone( caiDto.getTelephone() );
        cAI.setLatitude( caiDto.getLatitude() );
        cAI.setLongitude( caiDto.getLongitude() );
        cAI.setCity( caiDto.getCity() );

        return cAI;
    }

    @Override
    public void updateCai(CAIDto caiDto, CAI cai) {
        if ( caiDto == null ) {
            return;
        }

        if ( caiDto.getStation_name() != null ) {
            cai.setStation_name( caiDto.getStation_name() );
        }
        if ( caiDto.getTelephone() != null ) {
            cai.setTelephone( caiDto.getTelephone() );
        }
        cai.setLatitude( caiDto.getLatitude() );
        cai.setLongitude( caiDto.getLongitude() );
        if ( caiDto.getCity() != null ) {
            cai.setCity( caiDto.getCity() );
        }
    }
}
