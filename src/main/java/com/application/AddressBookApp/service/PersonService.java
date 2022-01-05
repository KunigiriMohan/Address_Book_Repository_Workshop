package com.application.AddressBookApp.service;

import java.util.List;
import java.util.Optional;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.exceptions.AddressBookCustomException;
import com.application.AddressBookApp.model.*;
import com.application.AddressBookApp.repository.AddressBookRepository;
import com.application.AddressBookApp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Service : Service Layer of Application
 * @Autowired : For Dependency Injection
 */
@Service
public class PersonService implements InterfacePerson{
    /**
     * AutoWiring for DependencyInjection
     */
    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressBookRepository addressBookRepository;

    /**
     * method to Show all Person Details in AddressBook
     * @return : Entered Person Data
     */
    @Override
    public List<Person> getPersonData() {
        return personRepository.findAll();
    }

    /**
     * method to return Person Details by ID
     * @param : personID
     * @param : addressBookID
     * @return : Person details of particular ID
     */
    @Override
    public Person getPersonDataById(Long personID) {
        return personRepository.findById(personID).orElseThrow(()-> new AddressBookCustomException("Person ID Not Found"));
    }

    /**
     * method to create a Person in Address Book
     * @param : personDTO
     * @param : addressBookID
     * @return : Entered Person Data
     */
    @Override
    public Person createPersonData(Long addressBookID,PersonDTO personDTO) {
        Person personData = new Person(personDTO);
        Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookID);
        if(addressBook.isPresent()){
            personData.setAddressBook(addressBook.get());
        }
        else{
            throw new AddressBookCustomException("Address Book Not Found");
        }
        return personRepository.save(personData);
    }

    /**
     * method to Update Person Data
     * @param : personDTO
     * @param : addressBookID
     * @return : Updated Person Data
     */
    @Override
    public Person updatePersonData(Long addressBookID,Long personID, PersonDTO personDTO) {
        Person personData = this.getPersonDataById(personID);
        personData.updatePerson(personDTO);
        Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookID);
        if(addressBook.isPresent()){
            personData.setAddressBook(addressBook.get());
        }
        else{
            throw new AddressBookCustomException("Address Book Not Found");
        }
        return personRepository.save(personData);
    }

    /**
     * method to delete person
     * @param : personID
      * @param : personID
     */
    @Override
    public void deletePersonData(Long personID) {
        Person person = this.getPersonDataById(personID);
        personRepository.delete(person);
    }
}
