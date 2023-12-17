package com.pushpa.LoginRegistration.Controller;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.pushpa.LoginRegistration.DTO.LoginDTO;
import com.pushpa.LoginRegistration.DTO.UserDTO;
import com.pushpa.LoginRegistration.Service.userService;
import com.pushpa.LoginRegistration.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO){
        String name=userService.addUser(userDTO);
        return name;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginResponse loginMessage=userService.loginuser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }

    @GetMapping
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/user")
    public Principal user(Principal principal){
        System.out.println("username : "+principal.getName());
        return principal;
    }

}
