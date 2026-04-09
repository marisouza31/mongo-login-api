package com.example.mongo.interfaces.controller;

import com.example.mongo.application.service.LoginService;
import com.example.mongo.domain.model.Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @GetMapping
    public String get() {
        return service.mensagem();
    }

    @PostMapping
    public Login criar(@RequestBody Login login) {
        return service.salvar(login);
    }

    @PutMapping("/{id}")
    public Login atualizar(@PathVariable String id, @RequestBody Login login) {
        return service.atualizar(id, login);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}