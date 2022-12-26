package com.krohina.lab5;

import com.krohina.lab5.reflection.Inter1;
import com.krohina.lab5.reflection.Inter2;

/**
 * Класс с полями, помеченными аннотацией AutoInjectable.
 */
public class RefClass {
    @AutoInjectable
    private Inter1 firstField;
    @AutoInjectable
    private Inter2 secondField;

    public RefClass() {
    }

    public void go(){
        firstField.doSome();
        secondField.doSome();
    }
}
