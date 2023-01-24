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

    public User createUser(User user) {
        log.info("Persistindo objeto");
        existsCpfOrEmail(user);
        Address address = addressService.searchAddress(user.getAddress().getCep());
        user.setAddress(address);
        User userModel = userRepository.save(user);
        log.info("Persistindo objeto");
        return userModel;

    }


    public ResponseEntity updateUser(@RequestBody User user, Long id) {
        return userRepository.findById(id).map(
                newUser -> {
                    newUser.setName(user.getName());
                    newUser.setCpf(user.getCpf());
                    newUser.setDateOfBirthday(user.getDateOfBirthday());
                    newUser.setEmail(user.getEmail());
                    newUser.setUserType(user.getUserType());
                    newUser.setPhoneNumber(user.getUserType());
                    newUser.setPassword(user.getPassword());
                    User updatedUser = userRepository.save(newUser);
                    return ResponseEntity.ok().body(updatedUser);
                }).orElseThrow(() -> new UserExceptionNotFound(("Id não localizado")));
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new UserExceptionNotFound("Usuário não encontrado");
        }
    }

    public void existsCpfOrEmail(User user) {
        Optional<User> userEntityCpf = userRepository.findByCpf(user.getCpf());
        Optional<User> UserEntityEmail = userRepository.findByEmail(user.getEmail());
        if (userEntityCpf.isPresent()) {
            throw new DuplicateUserException("CPF já cadastrado na aplicação");
        }
        if (UserEntityEmail.isPresent()) {
            throw new DuplicateUserException("Email já cadastrado na aplicação");
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
