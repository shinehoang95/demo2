package javademo.demo;
// lấy thời gian hệ thống

import java.text.*;
import java.util.*;

public class Bai11_GetTime {

    public static void main(String[] args) {
        //Get time by millisecond: (10^(-3)s)
        long start = System.currentTimeMillis();
        //Do something
        //Example
        try {
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(2);
            }
        } catch (Exception e) {

        }
        long end = System.currentTimeMillis();
        System.out.println("Millisecond = " + (end - start));

        //Get time by nanosecond
        start = System.nanoTime();
        end = System.nanoTime();
        System.out.println("Millisecond = " + (end - start));

        //Display the system time
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //dateFormat is variable declared format by Date
        Date date = new Date(); //set the system time
        String day = dateFormat.format(date);
        System.out.println(day);

    }
}
