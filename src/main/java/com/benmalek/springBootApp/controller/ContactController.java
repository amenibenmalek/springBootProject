package com.benmalek.springBootApp.controller;


import com.benmalek.springBootApp.Model.Contact;
import com.benmalek.springBootApp.Service.ContactService;
import com.benmalek.springBootApp.exception.NoContactException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {


  @Autowired
  private ContactService contactService;

  @GetMapping("/contacts")
  @ResponseBody
  public ResponseEntity<List<Contact>> getContacts() {
    return new ResponseEntity<>(contactService.getAllContact(),HttpStatus.OK);
  }

  @GetMapping("/contact/{id}")
  @ResponseBody
  public ResponseEntity<Contact> getContact(@PathVariable String id) {
    try {
      Contact contact = contactService.getContactById(id);
      return new ResponseEntity<>(contact, HttpStatus.OK);
    } catch(NoContactException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/contact")
  @ResponseBody
  public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
    Contact newContact = contactService.saveContact(contact);
    return new ResponseEntity<>(newContact , HttpStatus.CREATED);
  }

  @PutMapping("/contact/{id}")
  @ResponseBody
  public ResponseEntity<Contact> updateContact(@PathVariable String id,@RequestBody Contact contact) {
    try {
      contactService.updateContact(id, contact);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoContactException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  }

  @DeleteMapping("/contact/{id}")
  @ResponseBody
  public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
    try {
      contactService.deleteContact(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (NoContactException e ) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
