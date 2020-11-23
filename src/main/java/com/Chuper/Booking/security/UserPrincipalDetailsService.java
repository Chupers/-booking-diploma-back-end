package com.Chuper.Booking.security;

import com.Chuper.Booking.entity.UserFacade;
import com.Chuper.Booking.rest.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {


    private final UserService userService;

    public UserPrincipalDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserFacade userFacade = userService.findByUserName(s);
        return new UserPrincipal(userFacade);
    }
}
