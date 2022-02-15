package ru.mikhail.oauth2server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mikhail.oauth2server.jsonUtils.JsonUtils;
import ru.mikhail.oauth2server.service.PersonService;

import javax.servlet.http.HttpServletResponse;
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
//    @GetMapping("/get_all")
    @RequestMapping(
            value = "/get_all",
            method = RequestMethod.GET,
            produces="application/json"
    )
    @ResponseBody
    public String getAll(){
        return JsonUtils.arrayToJsonString(service.getAll());
    }
}
