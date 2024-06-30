package com.spring_security_jwt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring_security_jwt.dto.Login;
import com.spring_security_jwt.dto.Sessao;
import com.spring_security_jwt.model.User;
import com.spring_security_jwt.repository.UserRepository;
import com.spring_security_jwt.security.JWTCreator;
import com.spring_security_jwt.security.JWTObject;
import com.spring_security_jwt.security.SecurityConfig;

@Component
public class LoginService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityConfig securityConfig;

    @Autowired
    PasswordEncoder encoder;

    public Sessao logar(Login login){
        User user = userRepository.findByUsername(login.getUsername());
        if(user!=null){

            //testar senha
            boolean pwOk = encoder.matches(login.getPassword(), user.getPassword());
            if(!pwOk){
                throw new RuntimeException("Usuario ou senha invalidos");
            }
            //criando sessao
            Sessao sessao = new Sessao();
            sessao.setLogin(login.getUsername());

            //criar jwt
            JWTObject jwtObject = new JWTObject();
            jwtObject.setSubject(login.getUsername());
            jwtObject.setIssuedAt( new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis()+securityConfig.EXPIRATION));
            jwtObject.setRoles(user.getRoles());

            //settar login
            String token = JWTCreator.create(securityConfig.PREFIX, securityConfig.KEY, jwtObject);
            sessao.setToken(token);
            
            return sessao;
        }
        else{
            //caso de usuario inexistente
            throw new RuntimeException("Usuario nao encontrado");
        }
    }
}
