package com.br.atos.APIUsers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.Date;
import java.util.List;


@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "v_nome_completo", length = 120, nullable = false)
    @NotBlank(message = "Campo não pode ser nulo")
    @Size(min = 2, message = "nome invalido")
    private String name;

//    @Column(name = "v_cpf", length = 11, nullable = false, unique = true)
//    @CPF(message = "cpf informado invalido")
    private String cpf;

    @Column(nullable = false) //TODO inserir com formato br e validar a inserção
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR")
    private Date dateOfBirthday;

//    @Column(name = "v_email", length = 200, nullable = false, unique = true)
    @Email(message = "Email informado invalido")
    private String email;

    //    @NotNull
    private String userType;

    //    @NotNull
//    @Column(name = "v_phoneNumber", length = 11, nullable = false, unique = true)
    private String phoneNumber;

    //    @NotNull
    private String password;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Address> address;


}
