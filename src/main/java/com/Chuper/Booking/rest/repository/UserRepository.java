package com.Chuper.Booking.rest.repository;

import com.Chuper.Booking.entity.UserFacade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserFacade,Long> {
    UserFacade findUserFacadeByUserId(Long id);

    UserFacade findUserFacadeByUserName(String name);
}
