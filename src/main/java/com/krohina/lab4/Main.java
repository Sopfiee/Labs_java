package com.krohina.lab4;

import com.krohina.lab4.ObjectCSV;
import com.krohina.lab4.entities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Главный класс приложения.<br>
 * Содержит точку запуска, и меню для взаимодействия с пользователем.
 */
public class Main {

    /**
     * Стартовая точка приложения.<br>
     * Реализует меню для взаимодействия с пользователем.
     * @param args аргументы командной строки (массив строк).
     */
    public static void main(String[] args){
        String pathToCSV = System.getProperty("user.dir") + "\\src\\main\\resources\\foreign_names.csv";
        ArrayList<Person> cont = new ArrayList<>();
        ObjectCSV helper = new ObjectCSV(pathToCSV, ';', cont);
        try{
            helper.readFromCSV();
            helper.printCSVData();
            cont = new ArrayList<>(helper.getPersons());
        }
        catch(FileNotFoundException except){
            System.out.println("Таблица не найдена");
        }
    }
}