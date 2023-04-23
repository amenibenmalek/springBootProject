package com.benmalek.springBootApp.Model;
import org.hibernate.validator.constraints.NotBlank;

import java.util.UUID;

public class Contact {

  /**
   * id
   */
  private String id;

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @NotBlank(message = "Number cannot be blank")
  private String phoneNumber;

  public Contact(String id, String name, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public Contact() {
    this.id = UUID.randomUUID().toString();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


}
