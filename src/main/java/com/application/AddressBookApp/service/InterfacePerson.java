package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.model.*;

public interface InterfacePerson {
    /**
     * Methods of Service Layer
     */
    List<Person> getPersonData();
    Person getPersonDataById(Long personID);
    Person createPersonData(Long addressBookID,PersonDTO personDTO);
    Person updatePersonData(Long addressBookID,Long personID, PersonDTO personDTO);
    void deletePersonData(Long personID);
}
