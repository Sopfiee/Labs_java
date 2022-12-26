package com.krohina.lab5;

import java.io.IOException;


/**
 * Главный класс приложения.<br>
 * Содержит точку запуска.
 */
public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\inj.properties";
        RefClass cl = (new Injector<RefClass>(path).inject(new RefClass()));
        cl.go();
    }
}
