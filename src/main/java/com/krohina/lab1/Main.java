package com.krohina.lab1;

import java.util.Scanner;
import com.krohina.lab1.ForwardList;

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
    public static void main(String[] args) {
        test();
    }

    /**
     * Метод для пользовательского взаимодействия со списком.<br>
     * Позволяет пользователю путем ввода команд выполнять простейшие действия со списком.
     */
    private static void test()
    {
        String command = "";
        Scanner input = new Scanner(System.in);
        help();
        ForwardList<Integer> cont = new ForwardList<Integer>();

        while(command != "stop") {
            command = input.nextLine().toLowerCase().strip();
            String sub3="", sub4="", sub5="";

            if(command.length()>=3) {
                sub3 = command.substring(0, 3);
            }
            if(command.length()>=4) {
                sub4 = command.substring(0, 4);
            }if(command.length()>=5) {
                sub5 = command.substring(0, 5);
            }

            if (sub3.equals("pop")) {
                cont.pop();

            } else if (sub4.equals("push")) {
                cont.push(Integer.parseInt(command.substring(4).strip()));

            } else if (sub4.equals("help")) {
                help();

            } else if (sub4.equals("stop")) {
                command = "stop";

            } else if (sub5.equals("clear")) {
                cont.clear();

            } else if (sub5.equals("print")) {
                System.out.println(cont.toString());

            } else if (sub5.equals("front")) {
                try {
                    System.out.println("Первый элемент списка: " + cont.front());
                } catch(IndexOutOfBoundsException except) {
                    System.out.println("Ошибка, в списке нет первого элемента");
                }
            } else {
                System.out.println("Неопределённая команда, повторите ввод");
            }
            }
        }
    /**
     * Метод для вывода справочной информации пользователю.
     */
    private static void help(){
        System.out.println("""
                Командное меню:
                    push <value> - вставить <value> в начало списка
                    pop - удалить элемент из начала списка
                    front - получить первый элемент списка
                    clear - удалить все элементы списка
                    print - вывести содержимое списка
                                
                    help - справка
                    stop - завершить работу
                """);
    }
}