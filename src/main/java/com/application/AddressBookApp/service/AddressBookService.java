package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.exceptions.AddressBookCustomException;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Service : creating service layer
 * @Autowired : enabling automatic dependency Injection
 * @Override : Overriding implemented methods from interface
 */
@Service
public class AddressBookService implements IAddressBookService{

    /**
     * Autowiring AddressBookRepository to Dependency injection to save in DB
     */
    @Autowired
    AddressBookRepository addressBookRepository;

    /**
     * implementing method to get all AddressBooks
     */
    @Override
    public List<AddressBook> getAllAddressBook() {
        return addressBookRepository.findAll();
    }

    /**
     * implementing method to get AddressBook by its ID
     */
    @Override
    public AddressBook getAddressBookByID(Long addressBookID) {
        return addressBookRepository.findById(addressBookID).orElseThrow(()-> new AddressBookCustomException("Address Book ID Not Found"));
    }

    /**
     * implementing method to crete AddressBook in table
     */
    @Override
    public AddressBook createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }

    /**
     * implementing method to update AddressBook
     */
    @Override
    public AddressBook updateAddressBookByID(Long addressBookID, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = this.getAddressBookByID(addressBookID);
        addressBook.updateAddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
    }

    /**
     * implementing method to delete Address Book in DB
     */
    @Override
    public void deleteAddressBookByID(Long addressBookID) {
        AddressBook addressBook = this.getAddressBookByID(addressBookID);
        addressBookRepository.delete(addressBook);
    }
    
}
