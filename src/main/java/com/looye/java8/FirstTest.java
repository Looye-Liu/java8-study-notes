package main.java.com.looye.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FirstTest {

    public static void main(String[] args) {
        dateTest();
    }

    public static void lambdaTest() {
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) myList.add(i);
        System.out.println("<<<<<<<<Java8之前迭代方式start...>>>>>>>");
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
        }
        System.out.println("<<<<<<<<Java8之前迭代方式end.>>>>>>>");
        System.out.println("<<<<<<<<Java8使用forEach新迭代方式start...>>>>>>>");
        myList.forEach((s) -> {
            System.out.println("Iterator Value::" + s);
        });
        System.out.println("<<<<<<<<Java8使用forEach新迭代方式end.>>>>>>>");
    }

    public static void dateTest() {
        LocalDate date = LocalDate.of(2017, 6, 23);
        int year = date.getYear();//2017
        Month month = date.getMonth();//6
        int day = date.getDayOfMonth(); //23
        DayOfWeek dow = date.getDayOfWeek();//Fridiay
        int len = date.lengthOfMonth();//30lenghtofMonth
        boolean leap = date.isLeapYear();//false
        System.out.println(String.format("year:%s; month:%s; day:%s; dow:%s; len:%s; leap:%s", year, month, date, dow, len, leap));
    }

    public static void interfaceTest() {
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        //filter(listOfString, nonEmptyStringPredicate);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<T>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

}
