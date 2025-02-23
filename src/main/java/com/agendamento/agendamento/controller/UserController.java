package com.agendamento.agendamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.agendamento.dtos.UserDTO;
import com.agendamento.agendamento.entity.UserEntity;
import com.agendamento.agendamento.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userService.createUser(userDTO);
        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = this.userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
}
