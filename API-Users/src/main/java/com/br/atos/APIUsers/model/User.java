package com.br.atos.APIUsers.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private LocalDate dateOfBirthday;
    private String email;
    private String userType;
    private String phoneNumber;
    private String password;
    @Embedded
    private Address address;


}
