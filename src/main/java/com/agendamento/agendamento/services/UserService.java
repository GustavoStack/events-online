package com.agendamento.agendamento.services;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.agendamento.dtos.UserDTO;
import com.agendamento.agendamento.entity.UserEntity;
import com.agendamento.agendamento.entity.UserType;
import com.agendamento.agendamento.entity.exceptions.InvalideUserTypeException;
import com.agendamento.agendamento.entity.exceptions.TransactionDontAuthorizedException;
import com.agendamento.agendamento.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
    public UserEntity createUser(UserDTO userDTO) {
        UserEntity newUser = new UserEntity(userDTO);
        this.saveUser(newUser);
        return newUser;
    }
    public UserEntity getUserById(String id) {
        UserEntity user = this.userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + id);
        }
        return user;
    }
    public UserEntity getUserByEmail(String email){
        return this.userRepository.findUserByEmail(email);
    }
    public List<UserEntity> getAllUser(){
        return this.userRepository.findAll();
    }
    public void deleteById(String id){
        userRepository.deleteById(id);
    }
    //Verificando se o usuario é é null ou do tipo errado
    public void validateUserForEvent(UserEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        if (entity.getUserType() == UserType.COMMUN_USER) {
            throw new InvalideUserTypeException();
        }
    }
    public void validateTransaction(UserEntity entity){
        if(entity == null){
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        if(entity.getUserType() == UserType.OWNER_USER){
            throw new InvalideUserTypeException();
        }
    }
    //verificando se o usuario tem saldo suficiente
    public void validadeBalanceTransactional(UserEntity entity, BigDecimal value) {
        if(entity.getBalance().compareTo(value) < 0){
            throw new TransactionDontAuthorizedException();
        }
        if(entity.getUserType() == UserType.OWNER_USER){
            throw new InvalideUserTypeException();
        }
    }
}
