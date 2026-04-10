package com.example.mongo.application.service;

import com.example.mongo.domain.model.Login;
import com.example.mongo.infraestrutura.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository repository;
    private final EmailService emailService;

    public LoginService(LoginRepository repository, EmailService emailService) {

        this.repository = repository;
        this.emailService = emailService;
    }

    public Login salvar(Login login) {

        Login novoLogin = repository.save(login);

        emailService.enviarEmail(
                login.getEmail(),
                "Seu login foi realizado com sucesso!"
        );

        return novoLogin;
    }

    public Login atualizar(String id, Login novo) {
        Optional<Login> existente = repository.findById(id);

        if (existente.isPresent()) {
            Login login = existente.get();
            login.setUsername(novo.getUsername());
            login.setSenha(novo.getSenha());
            login.setRoles(novo.getRoles());
            return repository.save(login);
        }

        throw new RuntimeException("Não encontrado");
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public String mensagem() {
        return "realizar login";
    }
}