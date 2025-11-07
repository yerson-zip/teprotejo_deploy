package com.teprotejo.controller;

import com.teprotejo.dto.ContactDto;
import com.teprotejo.entity.Contact;
import com.teprotejo.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContact(@Valid @RequestBody ContactDto contactDto){


        HttpStatus response = contactService.save(contactDto) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(response).build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable("id") Long id){

        List<Contact> contact = contactService.contactById(id);

        HttpStatus response = contact != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(response).body(contact);


    }

}
