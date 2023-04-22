package ru.otus.demo.props;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.demo.config.PropertySourceFactoryYaml;
import ru.otus.demo.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Лучше вешать над конфигом
@PropertySource(value = "classpath:properties.yaml", factory = PropertySourceFactoryYaml.class)
@Data
@Component
public class YamlProps {

    @Value("${prop.not.really.existing:ValueDefault}")
    private String notReallyExistingPropWithDefaultValue;
    @Value("${prop.str}")
    private String strProp;

    @Value("${prop.int}")
    private String intPropAsStr;

    @Value("${prop.double}")
    private double doublePropAsStr;

    @Value("${prop.int}")
    private int intProp;

    @Value("${prop.double}")
    private double doubleProp;

    @Value("${prop.array}")
    private String[] strArrayProp;

    @Value("${prop.array}")
    private int[] intArrayProp;

    @Value("${prop.array}")
    private List<String> strArrayPropAsList;

    @Value("${prop.array}")
    private List<Integer> intArrayPropAsList;

    @Value("#{${prop.map}}")
    private Map<String, Integer> intMapProp;

    @Value("#{${prop.map}}")
    private Map<String, String> strMapProp;

    @Value("${prop.person}")
    private Person personProp;

    @Override
    public String toString() {
        return "YamlProps{" +
                "\n\tnotReallyExistingPropWithDefaultValue='" + notReallyExistingPropWithDefaultValue + '\'' +
                ", \n\tstrProp='" + strProp + '\'' +
                ", \n\tintPropAsStr='" + intPropAsStr + '\'' +
                ", \n\tdoublePropAsStr=" + doublePropAsStr +
                ", \n\tintProp=" + intProp +
                ", \n\tdoubleProp=" + doubleProp +
                ", \n\tstrArrayProp=" + Arrays.toString(strArrayProp) +
                ", \n\tintArrayProp=" + Arrays.toString(intArrayProp) +
                ", \n\tstrArrayPropAsList=" + strArrayPropAsList +
                ", \n\tintArrayPropAsList=" + intArrayPropAsList +
                ", \n\tintMapProp=" + intMapProp +
                ", \n\tstrMapProp=" + strMapProp +
                ", \n\tpersonProp=" + personProp +
                "\n}";
    }
}
