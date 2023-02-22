package com.cars.service;



import com.cars.bean.JwtRequest;
import com.cars.bean.JwtResponse;
import com.cars.bean.Role;
import com.cars.bean.User;
import com.cars.dao.UserDao;
import com.cars.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;



    @Service
    public class JwtService implements UserDetailsService {

        @Autowired
        private JwtUtil jwtUtil;

        @Autowired
        private UserDao userDao;

        @Autowired
        private AuthenticationManager authenticationManager;


        public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
            String userName = jwtRequest.getUserName();
            String userPassword = jwtRequest.getUserPassword();
            authenticate(userName, userPassword);
            final UserDetails userDetails = loadUserByUsername(userName);
            String newGeneratedToken = jwtUtil.generateToken(userDetails);
            User user = userDao.findByUserName(userName);
            return new JwtResponse(user, newGeneratedToken);
        }



        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userDao.findByUserName(username);

            if (user != null) {
                return new org.springframework.security.core.userdetails.User(
                        user.getUserName(),
                        user.getUserPassword(),
                        getAuthority(user)
                );
            } else {   throw new UsernameNotFoundException("User not found with username: " + username);

            }
        }

        private Set getAuthority(User user) {
            Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            if(user.getUserType().equals(Role.ADMIN))
                authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.ADMIN));
            else
                authorities.add(new SimpleGrantedAuthority("ROLE_" + Role.CUSTOMER));
            return authorities;
        }

        private void authenticate(String userName, String userPassword) throws Exception {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
            } catch (DisabledException e) {
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                throw new Exception("INVALID_CREDENTIALS", e);
            }
        }
    }


