package com.Chuper.Booking.rest.controller;


import com.Chuper.Booking.entity.UserFacade;
import com.Chuper.Booking.rest.service.UserService;
import com.Chuper.Booking.security.LoginModel;
import com.Chuper.Booking.security.UserRoleList;
import org.apache.tomcat.jni.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 10000)
@RestController
@RequestMapping("/user")
public class UserController {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/signUpCustomer")
    Long singUpCustomer(@RequestBody LoginModel loginModel){
        UserFacade userFacade = new UserFacade(loginModel.getUsername(),
                bCryptPasswordEncoder.encode(loginModel.getPassword()));
        userFacade.setUserRole(UserRoleList.USER);
        userService.save(userFacade);
        return userFacade.getUserId();
    }

    @PostMapping("/signUp")
    Long saveUser(@RequestBody LoginModel loginModel){
        UserFacade userFacade = new UserFacade(loginModel.getUsername(),
                bCryptPasswordEncoder.encode(loginModel.getPassword()));
        userFacade.setUserRole(UserRoleList.EMPLOYER);
        userService.save(userFacade);
        return userFacade.getUserId();
    }
}
