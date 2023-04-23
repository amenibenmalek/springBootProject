package com.benmalek.springBootApp.Service;


import com.benmalek.springBootApp.Model.Contact;
import com.benmalek.springBootApp.Repository.ContactRepository;
import com.benmalek.springBootApp.exception.ContactNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@ConditionalOnProperty(name = "server.port",havingValue = "9090")
public class ContactServiceImp implements ContactService {

  @Autowired
  ContactRepository contactRepository;

  public ContactServiceImp() {
    System.out.println("creating bean in port 9090");
  }

  @Override
  public Contact getContactById(String id) throws ContactNotFoundException {
    return contactRepository.getContact(findIndexById(id));
  }

  /**
   * Get index element from List
   * @param id
   * @return index
   */
  private int findIndexById(String id)  {
    return IntStream.range(0 , contactRepository.getContacts().size())
      .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
      .findFirst()
      .orElseThrow(() -> new ContactNotFoundException(id));
  }

  @Override
  public Contact saveContact(Contact contact) {
    contactRepository.saveContact(contact);
     return contactRepository.getContact(contactRepository.getContacts().size()-1);
  }

  @Override
  public List<Contact> getAllContact() {
    return contactRepository.getContacts();
  }

  @Override
  public void updateContact(String id, Contact contact) throws ContactNotFoundException{
   contactRepository.updateContact(findIndexById(id),contact);
  }

  @Override
  public void deleteContact(String id) throws ContactNotFoundException {
    contactRepository.deleteContact(findIndexById(id));
  }
}
