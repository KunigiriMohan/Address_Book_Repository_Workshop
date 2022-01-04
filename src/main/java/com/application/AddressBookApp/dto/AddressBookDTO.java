package com.application.AddressBookApp.dto;

import javax.validation.constraints.Pattern;

/**
 * AddressBook DTO Class 
 */
public class AddressBookDTO {

    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Address Book name is Invalid")
    public String addressBookName; 
}
