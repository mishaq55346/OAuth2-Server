package ru.mikhail.oauth2server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhail.oauth2server.service.PersonService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    PersonService service;
    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
    @GetMapping("/get_all")
    @ResponseBody
    public List<String> getAll(){
        return service.getAll().stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
