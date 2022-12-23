package com.krohina.lab4.entities;

import com.krohina.lab4.entities.Department;

/**
 * Класс для описания человека как объекта.<br>
 * Содержит следующие поля:<br>
 * <ul>
 *     <li>ID - уникальный идентификатор человека (int)</li>
 *     <li>name - имя (String)</li>
 *     <li>gender - пол (String)</li>
 *     <li>department - подразделение (Department)</li>
 *     <li>salary - зарплата (int)</li>
 *     <li>birthday - дата рождения (String)</li>
 * </ul><br>
 * Взаимодействие с полями осуществляется через соответствующие по именам геттеры и сеттеры.
 */
public class Person{

    private int ID;
    private String name;
    private String gender;
    private Department department;
    private int salary;
    private String birthday;

    /**
     * Конструктор без параметров.<br>
     * Заполняет поля пустыми значениями (0, null, "").
     */
    public Person(){
        this.ID = 0;
        this.name = "";
        this.gender = "";
        this.department = null;
        this.salary = 0;
        this.birthday = "";
    }

    /**
     * Конструктор по всем атрибутам класса.<br>
     * Заполняет соответствующие поля класса переданными значениями.
     * @param ID целочисленный уникальный идентификатор человека.
     * @param name имя человека.
     * @param gender пол человека.
     * @param department подразделение.
     * @param salary зарплата.
     * @param birthday день рождения.
     */
    public Person(int ID,
                  String name,
                  String gender,
                  Department department,
                  int salary,
                  String birthday){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthday = birthday;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    @Override
    public String toString(){
        return "ID: " + getID() +
                "\nИмя: " + getName() +
                "\nПол: " + getGender() +
                "\nЗарплата: " + getSalary() +
                "\nДата рождения: " + getBirthday();
    }
}