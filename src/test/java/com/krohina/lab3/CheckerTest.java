package com.krohina.lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.LinkedList;
import com.krohina.lab3.Checker;

/**
 * Класс для проведения unit-тестов класса Checker (3 Лаба).<br>
 * Представляет собой набор аннотированных методов для тестирования соответствующих по названию методов класса
 * Checker.<br>
 * Работает на основе библиотеки <b>Junit</b>.
 */
class CheckerTest {
    /**
     * unit-тест метода <b>timeByAdd</b>.<br>
     * Проверяет тип возвращаемого значения метода и исключение в случае плохих данных.
     */
    @Test
    void timeByAdd() {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Checker check = new Checker(2000);
        Integer badData = 5;
        Long goodValue = 10L;
        assertThrows(IllegalArgumentException.class, () -> {check.timeByAdd(badData);});
        assertEquals(check.timeByAdd(list).getClass(), goodValue.getClass());
        assertEquals(check.timeByAdd(arr).getClass(), goodValue.getClass());
    }
    /**
     * unit-тест метода <b>timeByGet</b>.<br>
     * Проверяет тип возвращаемого значения метода и исключение в случае плохих данных.
     */
    @Test
    void timeByGet() {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Checker check = new Checker(2000);
        Integer badData = 5;
        Long goodValue = 10L;
        assertThrows(IllegalArgumentException.class, () -> {check.timeByGet(badData);});
        assertEquals(check.timeByGet(list).getClass(), goodValue.getClass());
        assertEquals(check.timeByGet(arr).getClass(), goodValue.getClass());
    }
    /**
     * unit-тест метода <b>timeByDelete</b>.<br>
     * Проверяет тип возвращаемого значения метода и исключение в случае плохих данных.
     */
    @Test
    void timeByDelete() {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Checker check = new Checker(2000);
        Integer badData = 5;
        Long goodValue = 10L;
        assertThrows(IllegalArgumentException.class, () -> {check.timeByDelete(badData);});
        assertEquals(check.timeByDelete(list).getClass(), goodValue.getClass());
        assertEquals(check.timeByDelete(arr).getClass(), goodValue.getClass());
    }
}