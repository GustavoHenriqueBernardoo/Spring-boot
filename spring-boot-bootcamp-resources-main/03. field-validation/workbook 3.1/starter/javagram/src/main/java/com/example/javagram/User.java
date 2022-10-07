package com.example.javagram;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

  @NotBlank(message = "First name cannot be blank")
  @Size(min = 2, message = "First name is to short")
  private String firstName;

  private String lastName;

  @NotBlank(message = "Username cannot be blank")
  @Size(min = 7, message = "Username should have at least 7 characters")
  private String username;

  @Email(message = "Email is not well-formatted")
  private String email;

  @Past(message = "Date of birth must be on the past")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateOfBirth;

  public User(String firstName, String lastName, String username, String email, Date dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public User() {

  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

}
