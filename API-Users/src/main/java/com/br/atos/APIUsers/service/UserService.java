package com.br.atos.APIUsers.service;

import com.br.atos.APIUsers.exception.config.erros.DuplicateUserException;
import com.br.atos.APIUsers.exception.config.erros.UserExceptionNotFound;
import com.br.atos.APIUsers.model.Address;
import com.br.atos.APIUsers.model.User;
import com.br.atos.APIUsers.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressService addressService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUsersById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserExceptionNotFound("Id do usuário não localizado"));
    }

    public User createUser(User user) throws DuplicateUserException {

        if (userRepository.existsByCpf(user.getCpf())) {
            throw new DuplicateUserException("Já existe um usuário com este CPF.");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateUserException("Já existe um usuário com este e-mail.");
        }
        return userRepository.save(user);

    }


    public User updateUser(@RequestBody User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        throw new RuntimeException("Id inválido");

    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new UserExceptionNotFound("Usuário não encontrado");
        }
    }


    public ResponseEntity<User> searchCpf(String cpf) {
        try {
            Optional<User> user = userRepository.findByCpf(cpf);
            if (user.isEmpty()) {
                return ResponseEntity.notFound().build(); // status code 404
            }
            return ResponseEntity.ok(user.get()); // status code 200 com um body
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return ResponseEntity.internalServerError().build(); // status code 500
    }

    public ResponseEntity<User> searchEmail(String email) {
        try {
            Optional<User> user = userRepository.findByEmail(email);
            if (user.isEmpty()) {
                return ResponseEntity.notFound().build(); // status code 404
            }
            return ResponseEntity.ok(user.get()); // status code 200 com um body
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return ResponseEntity.internalServerError().build(); // status code 500
    }
}
