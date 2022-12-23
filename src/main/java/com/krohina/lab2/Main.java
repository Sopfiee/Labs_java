package com.krohina.lab2;

import java.util.Scanner;
import com.krohina.lab2.Calculator;
import java.util.Objects;

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

        boolean goodExpr;
        String str = "";
        Scanner in = new Scanner(System.in);

        while(!Objects.equals(str, "stop")){
            System.out.print("Введите выражение (stop-для завершения работы): ");
            str = in.nextLine();

            if(!Objects.equals(str, "stop")){
                Calculator exp = new Calculator(str);
                goodExpr = exp.calculate();

                if (!goodExpr) {
                    System.out.println("Выражение задано некорректно");
                } else {
                    System.out.print(str + " = ");
                    System.out.println(exp);
                }
            }
        }
    }
}