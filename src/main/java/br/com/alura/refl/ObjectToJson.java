package br.com.alura.refl;

import br.com.alura.Pessoa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {

    public static String convert(Object object) {
        String result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<>();
        Class<?> classToBeTransformed = object.getClass();

        for (Field field : classToBeTransformed.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                String key = field.getName();
                Object value = field.get(object);
                mapper.put(key, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        try {
            result = objectMapper.writeValueAsString(mapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }


}
