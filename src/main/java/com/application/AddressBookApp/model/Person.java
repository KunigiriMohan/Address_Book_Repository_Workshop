package com.application.AddressBookApp.model;

import com.application.AddressBookApp.dto.PersonDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To generate Construcor
 * @NoArgsConstructor : To Generate No Argument Constructor.
 * 
 */
@Data
@NoArgsConstructor
public class Person {

    /**
     * Variables of the classd
     */
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
    private String profilePic;


    public Person(PersonDTO personDTO){
        this.updatePerson(personDTO);
    }
    /**
     * Method to define variables of class
     */
    public void updatePerson(PersonDTO personDTO){
        this.firstName=personDTO.firstName;
        this.lastName=personDTO.lastName;
        this.gender = personDTO.gender;
        this.mobileNo=personDTO.mobileNo;
        this.emailAddress=personDTO.emailAddress;
        this.city=personDTO.city;
        this.state=personDTO.state;
        this.country=personDTO.country;
        this.address=personDTO.address;
        this.profilePic=personDTO.profilePic;
    }
}