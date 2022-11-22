package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Класс, реализующий представление работы методов контейнеров LinkedList и ArrayList в табличной форме
 */
public class Table {
    private TimeList element1;
    private TimeList element2;


    /**
     * Конструктор класса(инициализация полей element1 и element2)
     */
    public Table()
    {
        this.element1=new TimeList(new ArrayList<>());
        this.element2=new TimeList(new LinkedList<>());
    }

    /**
     * Метод создает таблицу в отдельном файле, в которой содержится информация о времени выполнения методов (N раз) контейнеров ArrayList и LinkedList соответственно
     */
    public void Table()
    {
        String file="file.txt";
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(file), StandardOpenOption.TRUNCATE_EXISTING))
        {
            String times=  Integer.toString(element1.getTimes());

            String str1,str2;
            Long time;
            writer.write("______________________________________________________________"+'\n');
            writer.write("|          Время выполнения функции в наносекундах           |"+'\n');
            writer.write("|____________________________________________________________|"+'\n');
            writer.write("|         |                  |          Тип Объекта          |"+'\n');
            writer.write("|  Метод  |   Сколько раз    |_______________________________|"+'\n');
            writer.write("|         |   выполняется    |   ArrayList   |  LinkedList   |"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

            time=element1.checkAddTime();
            str1=" "+Long.toString(time);
            while(str1.length()<15)
                str1+=" ";
            time=element2.checkAddTime();
            str2=" "+Long.toString(time);
            while(str2.length()<15)
                str2+=" ";

            writer.write("|  Add    |      " +times+"       |"+str1+"|"+str2+"|"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

            time=element1.checkSetTime();
            str1=" "+Long.toString(time);
            while(str1.length()<15)
                str1+=" ";
            time=element2.checkSetTime();
            str2=" "+Long.toString(time);
            while(str2.length()<15)
                str2+=" ";

            writer.write("|  Set    |      " +times+"       |"+str1+"|"+str2+"|"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

            time=element1.checkIndexTime();
            str1=" "+Long.toString(time);
            while(str1.length()<15)
                str1+=" ";
            time=element2.checkIndexTime();
            str2=" "+Long.toString(time);
            while(str2.length()<15)
                str2+=" ";

            writer.write("| IndexOf |      " +times+"       |"+str1+"|"+str2+"|"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

            time=element1.checkGetTime();
            str1=" "+Long.toString(time);
            while(str1.length()<15)
                str1+=" ";
            time=element2.checkGetTime();
            str2=" "+Long.toString(time);
            while(str2.length()<15)
                str2+=" ";

            writer.write("|   Get   |      " +times+"       |"+str1+"|"+str2+"|"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

            time=element1.checkRemoveTime();
            str1=" "+Long.toString(time);
            while(str1.length()<15)
                str1+=" ";
            time=element2.checkRemoveTime();
            str2=" "+Long.toString(time);
            while(str2.length()<15)
                str2+=" ";

            writer.write("| Remove  |      " +times+"       |"+str1+"|"+str2+"|"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

            time=element1.checkAddTime();
            str1=" "+Long.toString(time);
            while(str1.length()<15)
                str1+=" ";
            time=element2.checkAddTime();
            str2=" "+Long.toString(time);
            while(str2.length()<15)
                str2+=" ";

            writer.write("|  Add    |      " +times+"       |"+str1+"|"+str2+"|"+'\n');
            writer.write("|_________|__________________|_______________|_______________|"+'\n');

        }
        catch(IOException ex){
            ex.printStackTrace();
        }  ;
    }
}
