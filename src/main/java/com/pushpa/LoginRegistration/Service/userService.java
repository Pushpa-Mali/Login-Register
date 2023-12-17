package com.pushpa.LoginRegistration.Service;

import com.pushpa.LoginRegistration.DTO.LoginDTO;
import com.pushpa.LoginRegistration.DTO.UserDTO;
import com.pushpa.LoginRegistration.response.LoginResponse;

public interface userService {


    LoginResponse loginuser(LoginDTO loginDTO);

    String addUser(UserDTO userDTO);
}
