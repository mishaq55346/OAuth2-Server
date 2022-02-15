package ru.mikhail.oauth2server.jsonUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import ru.mikhail.oauth2server.model.Person;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils{
    private static final String WRITE_VALUE_EXCEPTION = "Exception occurred while writing an Object to JSON string";
    private static final String READ_VALUE_EXCEPTION = "Exception occurred while reading JSON string";
    public static <T> String arrayToJsonString(List<T> list){
        String s = "error";
        try {
            s = new JsonMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            System.err.println(WRITE_VALUE_EXCEPTION);
            e.printStackTrace();
        }
        return s;
    }
    public static <T> String objectToJsonString(T object){
        String s = "error";
        try {
            s = new JsonMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            System.err.println(WRITE_VALUE_EXCEPTION);
            e.printStackTrace();
        }
        return s;
    }
    public static Person jsonToPerson(String json){
        Person person = null;
        Object o = String.class;
        try {
            person = new JsonMapper().readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            System.err.println(READ_VALUE_EXCEPTION);
            e.printStackTrace();
        }
        return person;
    }
}
