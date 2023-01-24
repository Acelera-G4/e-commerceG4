package com.br.atos.APIUsers.controllers;

import com.br.atos.APIUsers.model.User;
import com.br.atos.APIUsers.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findyUserById(@PathVariable Long id) {
        log.info("realizando pesquisa do id: ",id);
        return userService.findUsersById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> searchCpf(@PathVariable String cpf) {
        log.info("realizando pesquisa do email: ",cpf);
        return userService.searchCpf(cpf);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<User> searchEmail(@PathVariable String email) {
        log.info("realizando pesquisa do email: ",email);
        return userService.searchEmail(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        log.info("iniciando o cadastro de um usuário: {}", user);
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody User user, @PathVariable Long id) {
        log.info("Usuário sendo autualizado...");
        return userService.updateUser(user, id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) {
        log.warn("usuário sendo excluído..");
        userService.deleteUser(id);
        log.warn("usuário excluida");
    }

}
