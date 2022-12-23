package com.krohina.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для проведения unit-тестов класса ForwardList (1 Лаба).<br>
 * Представляет собой набор аннотированных методов для тестирования соответствующих по названию методов класса
 * ForwardList.<br>
 * Работает на основе библиотеки <b>Junit</b>.
 */
class ForwardListTest {

    /**
     * unit-тест метода <b>push</b>.<br>
     * Проверяет по <b>equals</b> равенство содержимого списков после вставки.
     */
    @Test
    void push() {
        int data = 5;
        ForwardList<Integer> actual = new ForwardList<>();
        ForwardList<Integer> expected = new ForwardList<>();
        actual.push(data);
        expected.push(data);
        assertTrue(actual.equals(expected));
    }

    /**
     * unit-тест метода <b>pop</b>.<br>
     * Проверяет возвращаемое значение метода и после его выполнения - вид содержимого списка через <b>toString</b>.
     */
    @Test
    void pop() {
        int data = 5;
        ForwardList<Integer> actual = new ForwardList<>();
        assertFalse(actual.pop());
        actual.push(5);
        assertTrue(actual.pop());
        assertEquals(actual.toString(),"[]");
    }

    /**
     * unit-тест метода <b>front</b>.<br>
     * Проверяет, выбрасывается ли методом ожидаемое исключение <i>IndexOutOfBoundsException</i> и
     * действительно ли возвращаемый элемент совпадает с 1 элементом списка.
     */
    @Test
    void front() {
        ForwardList<Integer> actual = new ForwardList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {actual.front();});
        Integer data = 5;
        actual.push(data);
        assertTrue(actual.front().equals(data));
    }

    /**
     * unit-тест метода <b>size</b>.<br>
     * Проверяет количество элементов после выполнения операций: <b>push, pop, clear.</b>
     */
    @Test
    void size() {
        ForwardList<Integer> expected = new ForwardList<>();
        assertTrue(expected.size() == 0);
        for(int i = 5; i>=1; --i)
            expected.push(i);
        assertTrue(expected.size() == 5);
        expected.pop();
        assertTrue(expected.size() == 4);
        expected.clear();
        assertTrue(expected.size() == 0);
    }

    @Test
    void clear() {
    }

    /**
     * unit-тест метода <b>toString</b>.<br>
     * Проверяет ожидаемую строковую форму от вставки элементов методом <b>push</b> через строковый <b>equals</b>.
     */
    @Test
    void testToString() {
        ForwardList<Integer> expected = new ForwardList<>();
        assertEquals(expected.toString(), "[]");
        for(int i = 5; i>=1; --i)
            expected.push(i);
        assertEquals(expected.toString(), "[1, 2, 3, 4, 5]");
    }
}