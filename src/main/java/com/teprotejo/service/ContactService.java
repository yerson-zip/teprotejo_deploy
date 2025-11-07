package com.teprotejo.service;

import com.teprotejo.dto.ContactDto;
import com.teprotejo.entity.Contact;
import com.teprotejo.entity.User;
import com.teprotejo.mapper.ContactMapper;
import com.teprotejo.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {



    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public boolean save(ContactDto contactDto) {


        try{

            Contact  contact = contactMapper.toContact(contactDto);

            contact.setUser(new User(contactDto.getUserId()));

            contactRepository.save(contact);

            return true;
        }catch(Exception e){

            return false;
        }

    }


    public List<Contact> contactById(Long id){

        return contactRepository.findByUserId(id);

    }



}
