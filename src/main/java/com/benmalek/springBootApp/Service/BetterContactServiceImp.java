package com.benmalek.springBootApp.Service;


import com.benmalek.springBootApp.Model.Contact;
import com.benmalek.springBootApp.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(name = "server.port",havingValue = "8080")
public class BetterContactServiceImp implements ContactService {

  @Autowired
  ContactRepository contactRepository;


  public BetterContactServiceImp() {
    System.out.println("creating bean in port 8080");
  }


  @Override
  public Contact saveContact(Contact contact) {
    contactRepository.saveContact(contact);
    return contact;
  }

  @Override
  public List<Contact> getAllContact() {
    return null;
  }

  @Override
  public Contact getContactById(String id) {
    return contactRepository.getContact(Integer.parseInt(id));
  }

  @Override
  public void updateContact(String id, Contact contact) {

  }

  @Override
  public void deleteContact(String id) {

  }
}
