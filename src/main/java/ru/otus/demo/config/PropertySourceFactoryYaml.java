package ru.otus.demo.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.util.Objects;

public class PropertySourceFactoryYaml implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {
        var factory = new YamlPropertiesFactoryBean();

        var resource = encodedResource.getResource();
        factory.setResources(resource);

        var properties = factory.getObject();

        return new PropertiesPropertySource(Objects.requireNonNull(resource.getFilename()),
                Objects.requireNonNull(properties));
    }
}
