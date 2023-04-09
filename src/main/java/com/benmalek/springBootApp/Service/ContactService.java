package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

   Contact getContactById(String id);

   Contact saveContact(Contact contact);

   List<Contact> getAllContact();

   void updateContact(String id , Contact contact);
}
