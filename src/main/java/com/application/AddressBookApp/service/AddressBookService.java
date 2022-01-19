package com.application.AddressBookApp.service;

import java.util.List;
import java.util.Optional;

import com.application.AddressBookApp.dto.AddressBookDTO;
import com.application.AddressBookApp.exceptions.AddressBookCustomException;
import com.application.AddressBookApp.model.AddressBook;
import com.application.AddressBookApp.model.User;
import com.application.AddressBookApp.repository.AddressBookRepository;
import com.application.AddressBookApp.repository.UserRepository;
import com.application.AddressBookApp.utility.JwtTokenUtil;

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
     * Autowiring UserRepository for Dependency Injection to save in DB
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Autowiring JwtTokenUtil
     */
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * implementing method to get all AddressBooks
     */
    @Override
    public List<AddressBook> getAllAddressBook(String token) {
        if (jwtTokenUtil.isValidToken(token)){
            return addressBookRepository.findAll();
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

    /**
     * implementing method to get AddressBook by its ID
     */
    @Override
    public AddressBook getAddressBookByID(Long addressBookID,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            return addressBookRepository.findById(addressBookID).orElseThrow(()-> new AddressBookCustomException("Address Book ID Not Found"));
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

    /**
     * implementing method to crete AddressBook in table
     */
    @Override
    public AddressBook createAddressBook(AddressBookDTO addressBookDTO,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            AddressBook addressBook = new AddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

    /**
     * implementing method to update AddressBook
     */
    @Override
    public AddressBook updateAddressBookByID(Long addressBookID, AddressBookDTO addressBookDTO,String token) {
       if (jwtTokenUtil.isValidToken(token)){
        AddressBook addressBook = this.getAddressBookByID(addressBookID,token);
        addressBook.updateAddressBook(addressBookDTO);
        return addressBookRepository.save(addressBook);
       }
       else throw new AddressBookCustomException("Not Valid Token");
    }

    /**
     * implementing method to delete Address Book in DB
     */
    @Override
    public void deleteAddressBookByID(Long addressBookID,String token) {
        if (jwtTokenUtil.isValidToken(token)){
            AddressBook addressBook = this.getAddressBookByID(addressBookID,token);
            addressBookRepository.delete(addressBook);
        }
        else throw new AddressBookCustomException("Not Valid Token");
    }

    /**
     * implementing method cretingUser in DB
     */
    @Override
    public User createUser(User user){
        if(userRepository.findAll().size()==0){
            return userRepository.save(user);
        }
        else{
            User userDetails=userRepository.getUserDetails(user.getUserName() ,user.getPassWord());
            if(userDetails==null){
            return userRepository.save(user);   
            }
            else{
                throw new AddressBookCustomException("User Already Present");
            }  
        }
    }

    /**
     * implementing method generatingToken 
     */
    @Override
    public String generateToken(User user) {
        Optional<User> userOptional = userRepository.findById(userRepository.getUserDetails(user.getUserName() ,user.getPassWord()).getID());
        if(userOptional.isPresent()){

            return jwtTokenUtil.generateToken(user.getUserName());
        }
        else{
            throw new AddressBookCustomException("User Not Found");
        }   
    } 
}
