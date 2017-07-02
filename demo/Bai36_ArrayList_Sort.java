package javademo.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Bai36_ArrayList_Sort {

    public static void main(String[] args) {
        ProcessEmployee36 pe = new ProcessEmployee36();
        pe.create();
        pe.arrange();
        pe.show();
    }
}

class Employee36 {

    private String name;
    private Date birthday;
    private double salary;
    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public String getBirthday() {
        return dateFormat.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Employee36() {

    }

    public Employee36(String name, Date birthday, double salary) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class ProcessEmployee36 {

    ArrayList<Employee36> aemp = new ArrayList<>();
    Scanner k = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public void create() {
        System.out.print("Enter number of employee : ");
        int n = Integer.parseInt(k.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name [" + (i + 1) + "] : ");
            String name = k.nextLine();
            boolean continueLoop = true;
            Date birthday = null;
            do {
                try {
                    System.out.print("Enter birthday [" + (i + 1) + "] : ");
                    birthday = dateFormat.parse(k.nextLine());
                    continueLoop = false;
                } catch (ParseException e) {
                    System.out
                            .println("Error date format , please re-enter [dd-mm-yyyy]");
                    continueLoop = true;
                }
            } while (continueLoop);
            System.out.print("Enter salary [" + (i + 1) + "] : ");
            double salary = Double.parseDouble(k.nextLine());

            Employee36 emp = new Employee36(name, birthday, salary);

            aemp.add(emp);
        }
    }

    public void arrange() {
        System.out.println("The list after arranged by salary !");
//        Collections.sort(aemp, new Comparator<Employee36>() {
//            @Override
//            public int compare(Employee36 emp1, Employee36 emp2) {
        Collections.sort(aemp, (Employee36 emp1, Employee36 emp2) -> {
            // Sort the
            // list in
            // descending
            // salary
            if (emp1.getSalary() < emp2.getSalary()) {
                return 1; // sorting descending
            } else {
                if (emp1.getSalary() == emp2.getSalary()) {
                    return 0;
                } else {
                    return -1; // sorting ascending
                }
            }
        });
    }

    public void arrange2() {
        System.out.println("The list after arranged by name !");
//        Collections.sort(aemp, new Comparator<Employee36>() {
//            @Override
//            public int compare(Employee36 emp1, Employee36 emp2) {
//                return (emp1.getName().compareTo(emp2.getName()));
//            }
//        });
        Collections.sort(aemp, (Employee36 emp1, Employee36 emp2) -> (emp1.getName().compareTo(emp2.getName())));
    }

    public void show() {
        System.out.println("Information of employees :");
        for (int i = 0; i < aemp.size(); i++) {
            System.out.println("Name [" + (i + 1) + "] : "
                    + aemp.get(i).getName() + "\nBirthday [" + (i + 1) + "] : "
                    + aemp.get(i).getBirthday() + "\nSalary [" + (i + 1)
                    + "] : " + aemp.get(i).getSalary() + "\n");
        }
    }
}
