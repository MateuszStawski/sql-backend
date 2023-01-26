package pl.stawski.sql.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.stawski.sql.user.dto.UserLogin;
import pl.stawski.sql.user.repository.UserRepository;
import pl.stawski.sql.user.service.UserService;
import pl.stawski.sql.user.dao.UserEntity;

import java.io.IOException;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/register")
    public ResponseEntity<Object> addUser(@RequestBody UserEntity userEntity) throws IOException {
        userService.addUser(userEntity);
        return ResponseEntity.status(200).body(userEntity);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserLogin userLogin) throws IOException {
        UserEntity user = userRepository.findByUserName(userLogin.getEmail());
        if(user.getPassword().equals(userLogin.getPassword())){
            return ResponseEntity.status(200).body("34ljk5nbmvxc@#!^*$%a");
        }
        return ResponseEntity.status(400).body("WRONG PASSWORD");
    }
}
