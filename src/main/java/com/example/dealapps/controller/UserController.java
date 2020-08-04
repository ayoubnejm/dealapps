package com.example.dealapps.controller;

import com.example.dealapps.dto.UserDto;
import com.example.dealapps.exception.MyResourceNotFoundException;
import com.example.dealapps.model.User;
import com.example.dealapps.service.UserService;
import com.example.dealapps.util.RestPreconditions;
import com.google.api.client.util.Preconditions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NEJMEDDINE Ayoub
 * @created 28/07/2020 -16:57
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ApiOperation(value="Return all users.", notes="This is a public API", response=List.class)
    public List<UserDto> findAll() {
        List<User> users =  userService.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Get a user by id.", notes="This is a public API", response=UserDto.class)
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable long id) throws MyResourceNotFoundException {
        User user = userService.findById(id);
        RestPreconditions.checkFound(user);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }


    @PostMapping
    @ApiOperation(value="Create a user and return his id ", notes="This is a public API", response=Long.class)
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@Valid @RequestBody UserDto userDto) {
        Preconditions.checkNotNull(userDto);
        return userService.saveOrUpdate(userDto).getId();
    }


    @PutMapping(value = "/{id}")
    @ApiOperation(value="Update a user", notes="This is a public API")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @Valid @RequestBody UserDto userDto) {
        userDto.setId(id);
        Preconditions.checkNotNull(userDto);
        Preconditions.checkNotNull(userService.getById(userDto.getId()));
        userService.saveOrUpdate(userDto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="Delete a user", notes="This is a public API")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userService.getById(id);
        userService.deleteById(id);
    }


    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
