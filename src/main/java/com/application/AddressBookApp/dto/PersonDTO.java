package com.application.AddressBookApp.dto;


import lombok.ToString;

/**
 * @ToString : To Auto Generate toString() 
 */

public @ToString class PersonDTO {
    
    public String firstName;
    public String lastName;
    public String gender;
    public Long mobileNo;
    public String emailAddress;
    public String city;
    public String state;
    public String country;
    public String address;
    public String profilePic;

}

