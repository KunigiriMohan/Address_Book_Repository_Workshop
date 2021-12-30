package com.application.AddressBookApp.service;
import java.util.List;

import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.model.*;

public interface InterfacePerson {
    /**
     * Methods of Service Layer
     * 
     */
    List<Person> getPersonData();
    Person getPersonDataById(Long personID);
    Person createPersonData(PersonDTO personDTO);
    Person updatePersonData(Long personID, PersonDTO personDTO);
    void deletePersonData(Long personID);
}
