package javademo.demo;

//Iterator
import java.util.ArrayList;
import java.util.Iterator;

public class Unit52_Iterator {

    public static void main(String[] args) {
        ArrayList al = new ArrayList(); //

        al.add("Nguyen");
        al.add("Xuan");
        al.add("Lam");

        Iterator<String> iterator = al.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
