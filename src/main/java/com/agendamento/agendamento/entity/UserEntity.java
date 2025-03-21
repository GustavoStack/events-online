package com.agendamento.agendamento.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.agendamento.agendamento.dtos.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class UserEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal balance;
    private UserType userType;

    public UserEntity(UserDTO dto) {
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.email = dto.email();
        this.balance = dto.balance();
        this.userType = convertToEnum(dto.userType());
    }

    public UserType convertToEnum(UserType userType){
        if (userType == null) {
            return null;
        }
        String usuarioString = userType.toString();
        switch (usuarioString.toUpperCase()) {
            case "COMMUN_USER":
                return UserType.COMMUN_USER;
            case "OWNER_USER":
                return UserType.OWNER_USER;
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
