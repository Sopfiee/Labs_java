package com.krohina.lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для проведения unit-тестов класса Calculator (2 Лаба).<br>
 * Представляет собой набор аннотированных методов для тестирования соответствующих по названию методов класса
 * Calculator.<br>
 * Работает на основе библиотеки <b>Junit</b>.
 */
class CalculatorTest {

    /**
     * unit-тест метода <b>calculate</b>.<br>
     * Проверяет возвращаемое значение после вычисления выражения и его результат, если оно могло быть вычислено.
     */
    @Test
    void calculate() {
        Calculator c = new Calculator("++++");
        assertFalse(c.calculate());
        c.expression = "2+(+9)";
        assertFalse(c.calculate());
        c.expression = "((2-3)*3+5/(3+2))/2";
        assertTrue(c.calculate());
        assertEquals(c.toString(), "-1.0");
    }

    /**
     * unit-тест метода <b>toString</b>.<br>
     * Проверяет по <b>equals</b> содержимое поля <b>expression</b>.
     */
    @Test
    void testToString() {
        Calculator c = new Calculator("(2+3)*5");
        assertTrue(c.toString().equals("(2+3)*5"));
        c.expression = "25.0";
        assertTrue(c.toString().equals("25.0"));
    }

    /**
     * unit-тест метода <b>equals</b>.<br>
     * Проверяет по <b>equals</b> правильность сравнения с другим классом-вычислителем, а также с null.
     */
    @Test
    void testEquals() {
        Calculator c1 = new Calculator("abc");
        Calculator c2 = new Calculator("abc");
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(null));
        c2.expression = "cab";
        assertFalse(c1.equals(c2));
    }
}