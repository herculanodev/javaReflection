package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> source= input.getClass();
        Class<?> target= Class.forName(source.getName() + "DTO");

        O targetCLass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields =  target.getDeclaredFields();

                Arrays.stream(sourceFields).forEach(sourceField ->

                Arrays.stream(targetFields).forEach(targetField ->{
                        validate(sourceField, targetField);
                    try {
                        targetField.set(targetCLass, sourceField.get(input));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }));


        return targetCLass;



    }
    private void validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
        } else {
            System.out.println("Os campos são diferentes");
        }
    }

}