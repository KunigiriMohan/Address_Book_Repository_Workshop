package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.model.*;
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
     * @return : Person details of particular ID
     */
    @Override
    public Person getPersonDataById(Long personID) {
        return personRepository.findById(personID).get();
    }

    /**
     * method to create a Person in Address Book
     * @param : personDTO
     * @return : Entered Person Data
     */
    @Override
    public Person createPersonData(PersonDTO personDTO) {
        Person personData = new Person(personDTO);
        return personRepository.save(personData);
    }

    /**
     * method to Update Person Data
     * @param : personDTO
     * @return : Updated Person Data
     */
    @Override
    public Person updatePersonData(Long personID, PersonDTO personDTO) {
        Person personData = this.getPersonDataById(personID);
        personData.updatePerson(personDTO);
        return personRepository.save(personData);
    }

    /**
     * method to delete person
     * @param : personID
     */
    @Override
    public void deletePersonData(Long personID) {
        personRepository.deleteById(personID);
    }
    
    
}
