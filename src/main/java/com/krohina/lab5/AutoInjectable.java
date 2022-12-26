package com.krohina.lab5;

import java.lang.annotation.*;

/**
 * Аннотация AutoInjectable
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AutoInjectable {}
