package com.krohina.lab4;

import org.junit.jupiter.api.Test;
import com.krohina.lab4.ObjectCSV;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import com.krohina.lab4.entities.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для проведения unit-тестов класса ObjectCSV (4 Лаба).<br>
 * Представляет собой набор аннотированных методов для тестирования соответствующих по названию методов класса
 * ObjectCSV.<br>
 * Работает на основе библиотеки <b>Junit</b>.
 */
class ObjectCSVTest {

    /**
     * unit-тест метода <b>readFromCSV</b>.<br>
     * Проверяет тип возвращаемого значения метода и исключение в случае плохих данных.
     */
    @Test
    void readFromCSV() {
        ArrayList<Person> arr = new ArrayList<>();
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\foreign_names.csv";
        ObjectCSV helper = new ObjectCSV(path, ';', arr);
        boolean catchExcept = false;
        try{
            helper.readFromCSV();
            int expectedValue = helper.getPersons().get(5).getDepartment().getID();
            int actualValue = 6;
            assertEquals(expectedValue, actualValue);
            path = System.getProperty("user.dir");
            helper.setFilePath(path);
            helper.readFromCSV();
        }
        catch(FileNotFoundException except){
            catchExcept = true;
        }
        assertTrue(catchExcept);
    }
}