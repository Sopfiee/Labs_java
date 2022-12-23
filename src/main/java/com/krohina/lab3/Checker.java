package com.krohina.lab3;

import java.util.List;

/**
 * Класс-обработчик.<br>
 * Реализует методы для множественного вызова методов стандартных контейнеров
 * с измерением времени, потраченного на эти вызовы.
 */
public class Checker{
    /**
     * Поле, хранящее количество вызовов для измерения времени.
     */
    public int countOfCalls;

    /**
     * Конструктор без параметров.<br>
     * По умолчанию инициализирует класс для 1000 вызовов.
     */
    public Checker(){
        countOfCalls = 1000;
    }

    /**
     * Конструктор по количеству вызовов.
     * @param cntCalls количество последующих вызовов с измерением их времени выполнения.
     */
    public Checker(int cntCalls){
        countOfCalls = cntCalls;
    }

    /**
     * Метод измерения времени, потраченного на вызов метода <b>add</b>
     * <i>countOfCalls</i> раз у объекта.<br>
     * <b>Изменяет переданных объект!</b>
     * @param obj объект, у которого будет вызываться метод.<br>
     *            Обязательно должен быть наследником <i>List&lt;Integer&gt;</i>
     * @return Возвращает время выполнения метода в мс.
     * @throws IllegalArgumentException Выбрасывается в случае если переданный объект
     * не является наследником <i>List&lt;Integer&gt;</i>
     */
    public Long timeByAdd(Object obj) throws IllegalArgumentException{
        long startTime = System.currentTimeMillis();
        List<Integer> cont = null;

        try{
            cont = (List<Integer>) obj;
        }
        catch(ClassCastException except){
            throw new IllegalArgumentException("obj was bad type");
        }

        for(int i = 0; i < countOfCalls; ++i){
            cont.add(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    /**
     * Метод измерения времени, потраченного на вызов метода <b>get</b>
     * <i>countOfCalls</i> раз у объекта.<br>
     * Если объект не заполнен нужны количеством элементов, они будут добавлены автоматически.<br>
     * Вызов получения элемента осуществляется по всем индексам коллекции.<br>
     * <b>Изменяет переданных объект!</b>
     * @param obj объект, у которого будет вызываться метод.<br>
     *            Обязательно должен быть наследником <i>List&lt;Integer&gt;</i>
     * @return Возвращает время выполнения метода в мс.
     * @throws IllegalArgumentException Выбрасывается в случае если переданный объект
     * не является наследником <i>List&lt;Integer&gt;</i>
     */
    public Long timeByGet(Object obj) throws IllegalArgumentException{
        List<Integer> cont = null;

        try{
            cont = (List<Integer>) obj;
        }
        catch(ClassCastException except){
            throw new IllegalArgumentException("obj was bad type");
        }

        while(cont.size() < countOfCalls){
            cont.add(5);
        }

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < countOfCalls; ++i){
            int tmp = cont.get(i);
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
    /**
     * Метод измерения времени, потраченного на вызов метода <b>get</b>
     * <i>countOfCalls</i> раз у объекта.<br>
     * Если объект не заполнен нужны количеством элементов, они будут добавлены автоматически.<br>
     * Удаление осуществляется с конца.<br>
     * <b>Изменяет переданных объект!</b>
     * @param obj объект, у которого будет вызываться метод.<br>
     *            Обязательно должен быть наследником <i>List&lt;Integer&gt;</i>
     * @return Возвращает время выполнения метода в мс.
     * @throws IllegalArgumentException Выбрасывается в случае если переданный объект
     * не является наследником <i>List&lt;Integer&gt;</i>
     */
    public Long timeByDelete(Object obj) throws IllegalArgumentException{
        List<Integer> cont = null;

        try{
            cont = (List<Integer>) obj;
        }
        catch(ClassCastException except){
            throw new IllegalArgumentException("obj was bad type");
        }

        while(cont.size() < countOfCalls){
            cont.add(5);
        }

        long startTime = System.currentTimeMillis();
        for(int i = countOfCalls - 1; i >= 0; --i){
            int tmp = cont.remove(i);
        }
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
