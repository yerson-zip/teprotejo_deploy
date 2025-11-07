package com.teprotejo.mapper;

import com.teprotejo.dto.ContactDto;
import com.teprotejo.entity.Contact;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-06T22:52:24-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public Contact toContact(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setName( contactDto.getName() );
        contact.setTelefone( contactDto.getTelefone() );
        contact.setRelationship( contactDto.getRelationship() );

        return contact;
    }
}
