package com.cars.service;

import com.cars.bean.Role;
import com.cars.bean.User;
import com.cars.dao.UserDao;
import com.cars.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }


    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;

    }

    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;

    }

    @Override
    public UserDto addUser(User user) {
        User user1 = userDao.save(user);
        /* UserDto userDto=new UserDto();
         userDto.setUserType(user1.getUserType());
        userDto.setUserName(user1.getUserName());
        userDto.setUserEmail(user1.getUserEmail());
        */
        return this.userToDto(user1);
    }
}
/*
    @Override
    public UserDto viewUser(Integer userId) {
        Optional id=userDao.findById(userId);
        User user= (User) id.get();
        return this.userToDto(user);


    }

    @Override
    public List<UserDto> viewUsers() {
        List<User>userList=userDao.findAll();
        return userList.stream().map(post -> modelMapper.map(post, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(User user) {
        int id=user.getUserId();
     User user1=userDao.findById(id).orElseThrow();
     user1.setUserType(user.getUserType());
     user1.setUserName(user.getUserName());
     user1.setUserPassword(user.getUserPassword());
     user1.setUserPhone(user.getUserPhone());
     user1.setUserEmail(user.getUserEmail());
     User user2=userDao.save(user1);
     return this.userToDto(user2);
    }

    @Override
    public String deleteUser(Integer userId) {
         //convert BigInteger to integer
        if(userDao.findById(userId).isPresent())
            userDao.deleteById(userId);
        return "User Deleted Successfully";
    }

 */


