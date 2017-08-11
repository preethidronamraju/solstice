package com.preethi.contact.solstice.controller;

import com.preethi.contact.solstice.model.Contact;
import com.preethi.contact.solstice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by srujangopu on 8/11/17.
 */
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/solstice/createContact", method = RequestMethod.POST)
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createOrUpdateContact(contact);
    }

    @RequestMapping(value = "/solstice/contact/{contactId}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable String contactId){
        return contactService.getContact(contactId);
    }

    @RequestMapping(value = "/solstice/updateContact", method = RequestMethod.POST)
    public Contact updateContact(@RequestBody Contact contact){
        return contactService.createOrUpdateContact(contact);
    }

    @RequestMapping(value = "/solstice/deleteContact/{contactId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteContact(@PathVariable String contactId){
        contactService.deleteContact(contactId);
        return ResponseEntity.status(200).build();
    }

}