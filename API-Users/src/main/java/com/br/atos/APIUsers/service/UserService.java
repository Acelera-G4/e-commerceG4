package com.br.atos.APIUsers.service;

import com.br.atos.APIUsers.exception.UserExceptionNotFound;
import com.br.atos.APIUsers.model.User;
import com.br.atos.APIUsers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findyUsersById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserExceptionNotFound("Id não localizado"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
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
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity deleteUser(Long id) {
        return userRepository.findById(id).map(
                user -> {
                    userRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
}
