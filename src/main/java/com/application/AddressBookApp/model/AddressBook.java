package com.application.AddressBookApp.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.application.AddressBookApp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Data : Using Lombok to Generate getters and setters
 * @GeneratedValue : To auto generate i value
 * @Id : To Describe value as a Id in MySQL
 * @GenerateValue : To auto generate id value
 * @Column : To make that variable as a column
 * @Entity : To create class as entity
 * @Table : to Create table
 * @Data : To Auto Generated Getters and Setters
 * @NoArgsConstructor : Generating No Argument Constructor using Lombok
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "address_book_table")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressBookID")
    private Long addressBookID;

    @Column(name = "name")
    private String addressBookName;

	@Column(name = "personList")
    private List<Person> personList;

    /**
     * Defining custom Constructor 
     * @param addressBookDTO
     */
    public AddressBook(AddressBookDTO addressBookDTO){
        this.updateAddressBook(addressBookDTO);
    }

    /**
     * Creating Method to define varaiables of modal class
     * @param addressBookDTO
     */
    public void updateAddressBook(AddressBookDTO addressBookDTO){
        this.addressBookName = addressBookDTO.addressBookName;
        this.personList = addressBookDTO.personList;
    }
}
