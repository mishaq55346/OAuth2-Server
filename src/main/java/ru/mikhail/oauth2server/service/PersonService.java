package ru.mikhail.oauth2server.service;

import org.springframework.stereotype.Service;
import ru.mikhail.oauth2server.model.Person;
import ru.mikhail.oauth2server.repository.PersonRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {
    @Resource
    PersonRepository repository;

    public Person getPerson(String name, String password) {
        return repository.getElement(name, password);
    }
    public Person getPerson(String name) {
        System.out.println(name);
        Person element = repository.getElement(name);
        System.out.println(element);
        return element;
    }

    public void addPerson(Person person) {
        repository.addElement(person);
    }

    public void deletePerson(String name, String password) {
        repository.deleteElement(repository.getElement(name, password));
    }
}
