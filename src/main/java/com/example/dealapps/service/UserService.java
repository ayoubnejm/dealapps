package com.example.dealapps.service;

import com.example.dealapps.dto.UserDto;
import com.example.dealapps.exception.MyResourceNotFoundException;
import com.example.dealapps.model.User;

import java.util.List;

/**
 * @author NEJMEDDINE Ayoub
 * @created 03/08/2020 -17:04
 */
public interface UserService {

    /**
     * get users list
     * @return
     */
    List<User> findAll();

    /**
     * get user by id
     * @param id id
     * @return user founded
     * @throws MyResourceNotFoundException NotFoundException
     */
    User findById(Long id);

    /**
     * Create or update a User
     * @param userDto user
     * @return User created
     */
    User saveOrUpdate(UserDto userDto);

    /**
     * get By Id
     * @param id id of user
     * @return user founded
     */
    User getById(Long id);

    /**
     * delete a user by id
     * @param id of user
     */
    void deleteById(Long id);


}
