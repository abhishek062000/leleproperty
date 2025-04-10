package com.leleProperty.LeleProperty.model.request;

//RegistrationRequest.java (DTO for registration)
public class RegistrationRequest {
 private String username;
 private String password;

 // Constructors, getters, setters...

 public RegistrationRequest(){}

 public RegistrationRequest(String username, String password){
     this.username = username;
     this.password = password;
 }

 public String getUsername() {
     return username;
 }

 public void setUsername(String username) {
     this.username = username;
 }

 public String getPassword() {
     return password;
 }

 public void setPassword(String password) {
     this.password = password;
 }
}
