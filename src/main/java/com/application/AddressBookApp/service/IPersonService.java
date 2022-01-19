package com.application.AddressBookApp.service;

import java.util.List;
import com.application.AddressBookApp.dto.PersonDTO;
import com.application.AddressBookApp.model.*;

public interface IPersonService {
    /**
     * Methods of Service Layer
     */
    List<Person> getPersonData(String token);
    Person getPersonDataById(Long personID,String token);
    Person createPersonData(Long addressBookID,PersonDTO personDTO,String token);
    Person updatePersonData(Long addressBookID,Long personID, PersonDTO personDTO,String token);
    void deletePersonData(Long personID,String token);
}
