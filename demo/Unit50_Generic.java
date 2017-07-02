package javademo.demo;
//Generic 1

import java.util.ArrayList;

public class Unit50_Generic {

    public static void main(String[] args) {
        ArrayList<A> al = new ArrayList<A>();//A is a Generic in ArrayList
        al.add(new A());
        for (int i = 0; i < al.size(); i++) {
            al.get(i).showA1();
            al.get(i).showA2();
        }
    }
}

class A {

    public void showA1() {
        System.out.println("A1");
    }

    public void showA2() {
        System.out.println("A2");
    }
}

class B {

    public void showB() {
        System.out.println("B");
    }
}
