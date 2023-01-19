package com.br.atos.APIUsers.service;

import com.br.atos.APIUsers.exception.UserExceptionNotFound;
import com.br.atos.APIUsers.model.User;
import com.br.atos.APIUsers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
