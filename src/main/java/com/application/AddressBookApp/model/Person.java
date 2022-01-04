package com.application.AddressBookApp.model;

import com.application.AddressBookApp.dto.PersonDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data : To generate Getters and Setters
 * @NoArgsConstructor : To Generate No Argument Constructor.
 * @Entity : To Create Entity i.e Table
 * @Table : To Declare Entity as a Table and Setting Name
 * @Id : Creating Id in Table
 * @GeneratedValue : To Auto Generated Id
 * @Column : Declaring varible name as a Column Name
 * @ManyToOne : Mapping person_list table to addressBookTable using Foreign Key
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "person_list")
public class Person {

    /**
     * Variables of the class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personID")
    private Long personID;
    @Column(name = "name")
    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private String city;
    private String state;
    private String country;
    private String address;
    private String profilePic;

    @ManyToOne
    @JoinColumn(name = "fk_person_ID",referencedColumnName = "addressBookID")
    private AddressBook addressBook;

    /**
     * Defining Constructor
     * @param personDTO
     */
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