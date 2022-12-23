package com.krohina.lab4.entities;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс для описания подразделения как объекта.
 */
public class Department {

    private static AtomicInteger idCounter = new AtomicInteger(0);
    private int ID;
    private String title;

    /**
     * Конструктор без параметров.
     */
    public Department(){
        this.ID = createID();
        this.title = "noTitle";
    }

    /**
     * Конструктор по названию подразделения.
     */
    public Department(String title){
        this.ID = createID();
        this.title = title;
    }

    public int createID(){
        return idCounter.incrementAndGet();
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return "ID: " + this.getID() +
                "\nНазвание: " + this.getTitle();
    }
}