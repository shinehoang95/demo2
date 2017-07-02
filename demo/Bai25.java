package javademo.demo;

import java.util.Scanner;

public class Bai25 {

    public static void main(String[] args) {
        Student25 st = new Student25();
        st.input();
        st.arrangement();
        st.output();
        st.search();
    }
}

class Student25 {

    private String[] fullName;
    private int num;
    private String key;
    private String temp;
    Scanner k = new Scanner(System.in);

    public void input() {
        try {
            System.out.print("Enter the number of students : ");
            num = k.nextInt();
            if (num < 0) {
                throw new IllegalArgumentException(
                        "The number of students is greater than 0");
            }

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        k.nextLine();
        fullName = new String[num];
        System.out.println("Enter the full name of students");
        for (int j = 0; j < num; j++) {
            System.out.print("Student [" + (j + 1) + "] : ");
            fullName[j] = k.nextLine();
        }
    }

    public void output() {
        System.out.println("The people that you entered : ");
        for (int i = 0; i < num; i++) {
            System.out.println(fullName[i]);
        }
    }

    public void arrangement() {
        for (int i = 0; i < num - 1; i++) {
            for (int j = (i + 1); j < num; j++) {
                if (0 < fullName[i].compareToIgnoreCase(fullName[j])) {
                    temp = fullName[i];
                    fullName[i] = fullName[j];
                    fullName[j] = temp;
                }
            }
        }
    }

    public void search() {
        System.out.print("Enter the last name or first name that you find : ");
        key = k.nextLine();
        for (int i = 0; i < num; i++) {
            if (-1 != fullName[i].indexOf(key)) {
                System.out.println(fullName[i]);
            }
        }
    }
}
