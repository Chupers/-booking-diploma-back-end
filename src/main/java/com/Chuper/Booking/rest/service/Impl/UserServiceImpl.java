package com.Chuper.Booking.rest.service.Impl;

import com.Chuper.Booking.entity.UserFacade;
import com.Chuper.Booking.rest.repository.UserRepository;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    @Override
    public UserFacade save(UserFacade userFacade) {
        return userRepository.save(userFacade);
    }

    @Override
    public UserFacade findById(Long id) {
        return userRepository.findUserFacadeByUserId(id);
    }

    @Override
    public UserFacade findByUserName(String userName) {
        return userRepository.findUserFacadeByUserName(userName);
    }
}
