package com.cars.service;

import com.cars.bean.User;
import com.cars.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    //Create ,read,update,delete
    UserDto addUser(User user);

   /* UserDto viewUser(Integer userId);

    List<UserDto> viewUsers();

    UserDto updateUser(User user);

    String deleteUser(Integer userId);



    */
}
