package com.application.AddressBookApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To generate Construcor
 * @NoArgsConstructor : To Generate No Argument Constructor.
 * @AllArgsConstructor : To Generate All Argument Constructor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    
    private Long iD;
    private String firstName;
    private String lastName;
    private String gender;
    private Long mobileNo;
    private String emailAddress;
    private String city;
    private String state;
    private String country;
    private String address;
    private String profilepic;
}