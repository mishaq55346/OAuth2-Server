package ru.mikhail.oauth2server.service;

import org.springframework.stereotype.Service;
import ru.mikhail.oauth2server.model.MyToken;
import ru.mikhail.oauth2server.repository.TokenRepository;

import javax.annotation.Resource;

@Service
public class TokenService {
    @Resource
    TokenRepository repository;

    public MyToken getToken(int userId) {
        return repository.getElement(userId);
    }

    public void addToken(MyToken token) {
        repository.addElement(token);
    }

    public void deleteToken(int userId) {
        repository.deleteElement(userId);
    }
}
