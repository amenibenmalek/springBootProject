package com.benmalek.springBootApp.Service;


import com.benmalek.springBootApp.Model.Contact;
import com.benmalek.springBootApp.Repository.ContactRepository;
import com.benmalek.springBootApp.exception.NoContactException;
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
  public Contact getContactById(String id) throws NoContactException {
    return contactRepository.getContact(findIndexById(id));
  }

  /**
   * Get index element from List
   * @param id
   * @return index
   */
  private int findIndexById(String id) throws NoContactException {
    return IntStream.range(0 , contactRepository.getContacts().size())
      .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
      .findFirst()
      .orElseThrow(NoContactException::new);
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
  public void updateContact(String id, Contact contact) throws NoContactException{
   contactRepository.updateContact(findIndexById(id),contact);
  }

  @Override
  public void deleteContact(String id) throws NoContactException {
    contactRepository.deleteContact(findIndexById(id));
  }
}
