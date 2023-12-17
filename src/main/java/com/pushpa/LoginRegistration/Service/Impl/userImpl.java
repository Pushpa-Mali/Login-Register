package com.pushpa.LoginRegistration.Service.Impl;

import com.pushpa.LoginRegistration.DTO.LoginDTO;
import com.pushpa.LoginRegistration.DTO.UserDTO;
import com.pushpa.LoginRegistration.Entity.User;
import com.pushpa.LoginRegistration.Repository.userRepo;
import com.pushpa.LoginRegistration.Service.userService;
import com.pushpa.LoginRegistration.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userImpl implements userService {

    @Autowired
    private userRepo UserRepo;

    @Override
    public LoginResponse loginuser(LoginDTO loginDTO) {
        String mssg = "";
        User user = UserRepo.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO
                    .getPassword();
            String dbpass = user.getPassword();
            boolean val = password.equals(dbpass) ? true : false;

            if (val) {
                Optional<User> user1 = UserRepo.findOneByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
                if (user1.isPresent()) {
                    return new LoginResponse("login success", true);
                } else {
                    return new LoginResponse("login failed", false);
                }
            } else {
                return new LoginResponse("password not match", false);
            }
        }
        else {
            return new LoginResponse("Email does not exists", false);
        }

    }

    //    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
       User user=new User(
               userDTO.getId(),
               userDTO.getName(),
               userDTO.getEmail(),
//        this.passwordEncoder.encode(userDTO.getPassword())
               userDTO.getPassword()
       );

        UserRepo.save(user);

        return user.getName();
    }
}
