package com.application.AddressBookApp.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.ToString;

/**
 * @ToString : To Auto Generate toString() 
 * @Pattern : Defining Regex Pattern
 * @NotNull : Showing error message if Variable entry is not present
 */
public @ToString class PersonDTO {
    
    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person first name is Invalid")
    public String firstName;
    
    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Person last name is Invalid")
    public String lastName;
    
    @Pattern(regexp="male|female",message = "Gender needs to be male or female")
    public String gender;

    @Pattern(regexp = "^[6-9]{1}[0-9]{9,}$", message = "Phone Number is invalid")
    @NotNull(message = "Phone Number can not be null")
    public String mobileNo;

    @Pattern(regexp = "^[a-zA-Z0-9_+/#$%?~.-&*]+@[a-zA-Z0-9.-]+$", message = "Email is invalid")
    @NotNull(message = "Email should not empty")
    public String emailAddress;

    @NotNull(message = "City name should not empty")
    public String city;

    @NotNull(message = "State name should not empty")
    public String state;

    @NotNull(message = "Country name should not empty")
    public String country;

    @NotNull(message = "Address should not empty")
    public String address;

    @NotNull(message = "Profile Picture should not empty")
    public String profilePic;
}

