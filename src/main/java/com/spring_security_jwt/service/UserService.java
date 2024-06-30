package com.spring_security_jwt.service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring_security_jwt.model.User;
import com.spring_security_jwt.repository.UserRepository;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public void createUser(User user){
        String pass = user.getPassword();
        //criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        userRepository.save(user);
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public String removeUser(User user){
        Optional<User> remove = userRepository.findById(user.getId());
        if(remove!=null){
            userRepository.delete(user);
            return "Usuario removido";
        }
        else{
            return "Usuario nao encontrado";
        }
    }

    public String updateUser(User user){
        Optional<User> userUpdate = userRepository.findById(user.getId());
        if(userUpdate!=null){
            userRepository.save(user);
            return "Usuario"+user.getName()+"foi atualizado";
        }
        else{
            return "Usuario nao encontrado";
        }
        
    }
}
