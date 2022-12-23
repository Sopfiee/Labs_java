package com.krohina.lab4;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.krohina.lab4.entities.Department;
import com.krohina.lab4.entities.Person;
import java.io.*;
import java.util.List;


/**
 * Класс-обработчик csv-файлов.
 */
public class ObjectCSV{
    private String filePath;
    private char separator;
    private List<Person> persons;

    /**
     * Конструктор по атрибутам классам.
     * @param filePath путь к CSV файлу в системе.
     * @param separator символ-разделитель, используемый в этом файле.
     * @param persons ссылка на список людей, для заполнения.
     */
    public ObjectCSV(String filePath, char separator, List<Person> persons){
        this.filePath = filePath;
        this.separator = separator;
        this.persons = persons;
    }

    /**
     * Метод считывания данных с csv-файла.
     * @throws FileNotFoundException если файл не найден.
     */
    public void readFromCSV() throws FileNotFoundException{
        try (FileReader in = new FileReader(filePath)) {
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader reader = new CSVReaderBuilder(in).withCSVParser(parser).withSkipLines(1).build();
            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Person person = new Person(Integer.valueOf(nextLine[0]),    //id
                        nextLine[1],                                        //имя
                        nextLine[2],                                        //гендер
                        new Department(nextLine[4]),                        //подразделение
                            Integer.valueOf(nextLine[5]),                   //зарплата
                            nextLine[3]);                                   //дата рождения
                persons.add(person);
            }
        } catch (IOException | CsvValidationException e) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Метод печати информации о всех записанных людях.
     */
    public void printCSVData() {
        for(int i = 0; i < persons.size(); i++){
            System.out.print("Человек: ");
            System.out.print(persons.get(i).getID() + "\t");
            System.out.print(persons.get(i).getName() + "\t");
            System.out.print(persons.get(i).getGender() + "\t");
            System.out.print(persons.get(i).getBirthday() + "\t");
            System.out.print("Подразделение: ");
            System.out.print(persons.get(i).getDepartment().getID() + "\t");
            System.out.print(persons.get(i).getDepartment().getTitle() + "\t");
            System.out.println(persons.get(i).getSalary() + "\t");
        }
    }

    public String getFilePath(){
        return filePath;
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public char getSeparator(){
        return separator;
    }

    public void setSeparator(char separator){
        this.separator = separator;
    }

    public List<Person> getPersons(){
        return persons;
    }

    public void setPersons(List<Person> persons){
        this.persons = persons;
    }
}
