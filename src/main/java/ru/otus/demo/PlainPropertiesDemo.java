package ru.otus.demo;

import java.io.IOException;
import java.util.Properties;

public class PlainPropertiesDemo {
    public static void main(String[] args) {
        showProperties();
    }

    private static void showProperties() {
        var simplePropertiesStream =  PlainPropertiesDemo.class
                .getClassLoader().getResourceAsStream("simple.properties");

        try (simplePropertiesStream){
            Properties properties = new Properties();
            properties.load(simplePropertiesStream);

            properties.list(System.out);

            System.out.println("\nИЛИ\n");

            var strProp = properties.getProperty("str.prop");
            var intProp = Integer.valueOf(properties.getProperty("int.prop"));
            var doubleProp = Double.valueOf(properties.getProperty("double.prop"));
            System.out.printf("Свойство \"str.prop\": %s%n", strProp);
            System.out.printf("Свойство \"int.prop\": %d%n", intProp);
            System.out.printf("Свойство \"double.prop\": %.2f%n", doubleProp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
