package com.krohina.lab5;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс, содержащий Метод принимающий объект любого класса и ищущий поля помеченные <br>
 * аннотацией AutoInjectable. Инициализирует эти поля экземплярами классов, <br>
 * указанных в реализации соответствующего интерфейса в файле настроек (properties).<br>
 */
public class Injector<T> {
    private final Properties properties;

    Injector(String pathToPropertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(pathToPropertiesFile)));
    }

    T inject(T obj) throws IOException, IllegalAccessException, InstantiationException {
        Class dependency;
        Class cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field field: fields){
            Annotation a = field.getAnnotation(AutoInjectable.class);
            if (a != null){
                String[] fieldType = field.getType().toString().split(" ");
                String equalsClassName = properties.getProperty(fieldType[1], null);
                if (equalsClassName != null){
                    try {

                        dependency = Class.forName(equalsClassName);
                    } catch (ClassNotFoundException e){
                        System.out.println("Not found class for " + equalsClassName);
                        continue;
                    }
                    field.setAccessible(true);
                    field.set(obj, dependency.newInstance());
                }
                else
                    System.out.println("Not found properties for field type " + fieldType[1]);
            }
        }
        return obj;
    }
}
