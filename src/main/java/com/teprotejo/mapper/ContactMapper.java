package com.teprotejo.mapper;

import com.teprotejo.dto.ContactDto;
import com.teprotejo.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {


    Contact toContact(ContactDto contactDto);

}
