package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.model.AddressBook;

/**
 * Service Layer Interface
 */
public interface IAddressBookService {
    /**
     * Creating Methods to Perform CURD operation
     */
    public List<AddressBook> getAllAddressBook();
    public AddressBook getAddressBookByID(Long addressBookID);
    public AddressBook createAddressBook(AddressBookDTO addressBookDTO);
    public AddressBook updateAddressBookByID(Long addressBookID,AddressBookDTO addressBookDTO);
    public void deleteAddressBookByID(Long addressBookID);
}
