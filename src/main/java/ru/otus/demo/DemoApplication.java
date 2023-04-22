package ru.otus.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.demo.props.CustomProps;
import ru.otus.demo.props.HardProps;
import ru.otus.demo.props.SimpleProps;
import ru.otus.demo.props.YamlProps;


@ComponentScan
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		// Environment var: not.really.existing.prop=Не видишь суслика, а он есть (с)
		// VM Option: -Dnot.really.existing.prop="Не видишь суслика, а он есть 2 (с)"
		// System.setProperty("not.really.existing.prop", "Не видишь суслика, а он есть 3 (с)");

		var ctx = new AnnotationConfigApplicationContext(DemoApplication.class);

		outputPropertiesBean(ctx, SimpleProps.class);
		outputPropertiesBean(ctx, HardProps.class);
		outputPropertiesBean(ctx, CustomProps.class);
		outputPropertiesBean(ctx, YamlProps.class);
	}

	private static void outputPropertiesBean(ApplicationContext ctx, Class<?> propertiesBeanClass) {
		var propertiesBean = ctx.getBean(propertiesBeanClass);
		System.out.println(propertiesBean);
		System.out.println("------------------------------------------------------");
	}
}
