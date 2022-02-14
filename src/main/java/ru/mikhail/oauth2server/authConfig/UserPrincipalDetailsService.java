package ru.mikhail.oauth2server.authConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mikhail.oauth2server.model.Person;
import ru.mikhail.oauth2server.service.PersonService;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private PersonService personService;

    public UserPrincipalDetailsService(PersonService personService) {
        this.personService = personService;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = this.personService.getPerson(s);
        UserPrincipal userPrincipal = new UserPrincipal(person);

        return userPrincipal;
    }
}
