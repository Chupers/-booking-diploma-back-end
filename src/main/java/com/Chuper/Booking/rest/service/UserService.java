package com.Chuper.Booking.rest.service;

import com.Chuper.Booking.entity.UserFacade;

public interface UserService {

    UserFacade save(UserFacade userFacade);

    UserFacade findById(Long id);

    UserFacade findByUserName(String userName);
}
