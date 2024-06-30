package com.spring_security_jwt.controller;

import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_jwt.dto.Login;
import com.spring_security_jwt.dto.Sessao;
import com.spring_security_jwt.model.User;
import com.spring_security_jwt.repository.UserRepository;
import com.spring_security_jwt.security.JWTCreator;
import com.spring_security_jwt.security.JWTObject;
import com.spring_security_jwt.security.SecurityConfig;
import com.spring_security_jwt.service.LoginService;
import com.spring_security_jwt.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired UserService userService;

    @PostMapping
    public Sessao logar(@RequestBody Login login){
        return loginService.logar(login);
    }

}
