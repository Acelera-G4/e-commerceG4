package com.br.atos.APIUsers.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userType;
    private String name;
    private String cpfCnpj;
    private String phoneNumber;
    private String email;
    private LocalDateTime dateOfBirthday;
    private String password;
    private Address address;


}
