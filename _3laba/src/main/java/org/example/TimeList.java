package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * Класс, реализующий подсчет времени выполнения фуннкций, встроенных в List
 */
public class TimeList {
    private List<Double> element;
    final int times=10000;

    /**
     *  Конструктор класса (инициализация поля element)
     */
    public TimeList(List<Double> element)
    {
        this.element=element;
    }

    /**
     * Метод возвращает количество повторений
     * @return кол-во повторений
     */
    public int getTimes()
    {
        return times;
    }

    /**
     * Метод подсчитывает среднее время выполнения N раз метода add в контейнере
     * @return время выполнения
     */
    public long checkAddTime()
    {
        int new_times=0;
        double x= Math.random();
        long time=0;
        long mid_time=0;
        for(int i=0;i<=5;i++)
        {
            Instant begin = Instant.now();
            while (new_times <= times) {
                element.add(x);
                new_times++;
            }
            Instant end = Instant.now();
            time = Duration.between(begin, end).toNanos();
            mid_time+=time;
        }
        mid_time=mid_time/5;
        return mid_time;
    };

    /**
     * Метод подсчитывает среднее время выполнения N раз метода remove в контейнере
     * @return время выполнения
     */
    public long checkRemoveTime()
    {
        long time = 0, mid_time=0;
        if(!element.isEmpty()&&times<=element.size()) {
            int new_times = 0;
            Instant begin,end;
            double x;
            for(int i=0;i<=5;i++)
            {
                while (new_times <= times) {

                x = element.get(0);
                begin = Instant.now();
                element.remove(x);
                end = Instant.now();
                time = time + Duration.between(begin,end).toNanos();
                new_times++;
            }
            mid_time+=time;
        }
        mid_time=mid_time/5;
        }
        return mid_time;
    };

    /**
     * Метод подсчитывает среднее время выполнения N раз метода get в контейнере
     * @return время выполнения
     */
    public long checkGetTime()
    {
        int new_times=0;
        int j=0;
        long time=0;
        long mid_time=0;
        if(!element.isEmpty()&&times<=element.size()) {
            for(int i=0;i<=5;i++)
            {
            Instant begin = Instant.now();
            while (new_times <= times && j <= element.size()) {
                element.get(j);
                j++;
                new_times++;
            }
            Instant end = Instant.now();
            time = Duration.between(begin, end).toNanos();
            mid_time+=time;
            }
            mid_time=mid_time/5;
        }
        return mid_time;
    };

    /**
     * Метод подсчитывает среднее время выполнения N раз метода set в контейнере
     * @return время выполнения
     */
    public long  checkSetTime()
    {
        int new_times=0;
        double x= Math.random();
        long time=0;
        long mid_time=0;
        for(int i=0;i<=5;i++)
        {
        Instant begin = Instant.now();
        while(new_times<=times)
        {
            element.set(0,x);
            new_times++;
        }
        Instant end = Instant.now();
        time= Duration.between(begin,end).toNanos();
            mid_time+=time;
        }
        mid_time=mid_time/5;
        return mid_time;
    }


    /**
     * Метод подсчитывает среднее время выполнения N раз метода indexOf в контейнере
     * @return время выполнения
     */
    public long  checkIndexTime()
    {
        int new_times=0;
        double x= Math.random();
        long time=0;
        int index=0;
        x = element.get(0);
        long mid_time=0;
        for(int i=0;i<=5;i++)
        {
        Instant begin = Instant.now();
        while(new_times<=times)
        {
            index=element.indexOf(x);
            new_times++;
        }
        Instant end = Instant.now();
        time= Duration.between(begin,end).toNanos();
        mid_time+=time;
        }
        mid_time=mid_time/5;
        return mid_time;
    }

    /**
     * Метод подсчитывает среднее время выполнения N раз метода contains в контейнере
     * @return время выполнения
     */
    public long  checkContainsTime()
    {
        int new_times=0;
        long time=0, mid_time=0;
        int index=0;
        if(!element.isEmpty()&&times<=element.size()) {
            double x= element.get(0);
            for(int i=0;i<=5;i++)
            {
            Instant begin = Instant.now();
            while (new_times <= times) {
                element.contains(x);
                new_times++;
            }
            Instant end = Instant.now();
            time = Duration.between(begin, end).toNanos();
                mid_time+=time;
            }
        }
        return mid_time;
    }
    }
