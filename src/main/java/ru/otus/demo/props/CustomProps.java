package ru.otus.demo.props;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.demo.model.Person;

import java.util.List;

// Лучше вешать над конфигом
@PropertySource("classpath:custom.properties")
@Data
@Component
public class CustomProps {
    @Value("${list.prop}")
    private List<String> strArrayPropAsList;
    @Value("${list.prop}")
    private List<Integer> intArrayPropAsList;
    @Value("${person.prop}")
    private Person personProp;

    @Value("${person.list.prop}")
    private List<Person> personListProp;
    @Override
    public String toString() {
        return "CustomProps{" +
                "\n\tstrArrayPropAsList=" + strArrayPropAsList +
                ", \n\tintArrayPropAsList=" + intArrayPropAsList +
                ", \n\tpersonProp=" + personProp +
                ", \n\tpersonListProp=" + personListProp +
                "\n}";
    }
}
