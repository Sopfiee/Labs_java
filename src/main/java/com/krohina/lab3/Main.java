package com.krohina.lab3;

import java.util.Scanner;
import com.krohina.lab3.Checker;
import java.util.ArrayList;
import java.util.LinkedList;

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
        Checker check = new Checker();
        int[] arrOfCalls = {1000, 5000, 20000, 100000};
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer cntCalls : arrOfCalls){
            check.countOfCalls = cntCalls;
            System.out.println("Для количества операций = " + cntCalls.toString() + ":");
            System.out.printf("ArrayList.add() : %d мс\t\t\tLinkedList.add() : %d мс\n",
                    check.timeByAdd(arr), check.timeByAdd(list));
            System.out.printf("ArrayList.get() : %d мс\t\t\tLinkedList.get() : %d мс\n",
                    check.timeByGet(arr), check.timeByGet(list));
            System.out.printf("ArrayList.remove() : %d мс\t\tLinkedList.remove() : %d мс\n",
                    check.timeByDelete(arr), check.timeByDelete(list));
        }
    }
}