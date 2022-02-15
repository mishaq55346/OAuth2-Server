package ru.mikhail.oauth2server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DisplayablePerson {
    private String name;
    private boolean enabled;
    private String roles = "";
    private String permissions = "";
    public List<String> getRoles() {
        if (roles == null)
            return new ArrayList<>();
        return Arrays.asList(roles.split(","));
    }
    public List<String> getPermissions() {
        if (permissions == null)
            return new ArrayList<>();
        return Arrays.asList(permissions.split(","));
    }
}
