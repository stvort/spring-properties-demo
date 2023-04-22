package ru.otus.demo.props;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Лучше вешать над конфигом
@PropertySource("classpath:hard.properties")
@Data
@Component
public class HardProps {
    @Value("${array.prop}")
    private String[] strArrayProp;
    @Value("${array.prop}")
    private int[] intArrayProp;
    @Value("#{${list.expr.prop}}")
    private List<String> strArrayPropAsList;
    @Value("#{${list.expr.prop}}")
    private List<Integer> intArrayPropAsList;
    @Value("#{${map.expr.prop}}")
    private Map<String, Integer> intMapProp;
    @Value("#{${map.expr.prop}}")
    private Map<String, String> strMapProp;

    @Override
    public String toString() {
        return "HardProps{" +
                "\n\tstrArrayProp=" + Arrays.toString(strArrayProp) +
                ", \n\tintArrayProp=" + Arrays.toString(intArrayProp) +
                ", \n\tstrArrayPropAsList=" + strArrayPropAsList +
                ", \n\tintArrayPropAsList=" + intArrayPropAsList +
                ", \n\tintMapProp=" + intMapProp +
                ", \n\tstrMapProp=" + strMapProp +
                "\n}";
    }
}
