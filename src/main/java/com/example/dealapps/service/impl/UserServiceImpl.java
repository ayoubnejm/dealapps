package com.example.dealapps.service.impl;

import com.example.dealapps.dto.UserDto;
import com.example.dealapps.model.User;
import com.example.dealapps.repository.UserRepository;
import com.example.dealapps.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author NEJMEDDINE Ayoub
 * @created 28/07/2020 -16:55
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id)  {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User saveOrUpdate(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
