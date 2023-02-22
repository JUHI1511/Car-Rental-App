package com.cars.controller;

import com.cars.bean.User;
import com.cars.dto.UserDto;
import com.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/registerUser")
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        UserDto user1=userService.addUser(user);
        return  new ResponseEntity<>(user1, HttpStatus.OK);
    }
}
    /*
    @GetMapping(path="/getuser/{userId}")
    public UserDto  viewUser(@PathVariable int userId){
        return userService.viewUser(userId);

    }
    @GetMapping(path="/getusers")
        public List<UserDto> viewUsers(){
            return userService.viewUsers();
    }
    @PutMapping(path="/updateuser")
        public UserDto updateUser(@RequestBody User user){
            return userService.updateUser(user);

        }
    @DeleteMapping(path="/deleteuser/{userId}")
    public String deleteUser(@PathVariable int userId){
            userService.deleteUser(userId);
            return "User Deleted Successfully";

    }
    }
*/
