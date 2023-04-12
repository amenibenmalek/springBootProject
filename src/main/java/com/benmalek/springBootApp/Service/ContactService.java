package com.benmalek.springBootApp.Service;

import com.benmalek.springBootApp.Model.Contact;
import com.benmalek.springBootApp.exception.NoContactException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {

   Contact getContactById(String id) throws NoContactException;

   Contact saveContact(Contact contact);

   List<Contact> getAllContact();

   void updateContact(String id , Contact contact) throws NoContactException;

   void deleteContact(String id) throws NoContactException;
}
