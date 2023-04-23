package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Contact;
import com.benmalek.springBootApp.exception.ContactNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

   Contact getContactById(String id) throws ContactNotFoundException;

   Contact saveContact(Contact contact);

   List<Contact> getAllContact();

   void updateContact(String id , Contact contact) throws ContactNotFoundException;

   void deleteContact(String id) throws ContactNotFoundException;
}
