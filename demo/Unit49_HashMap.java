package javademo.demo;
//Map

import java.util.HashMap;
import java.util.Scanner;

public class Unit49_HashMap {

    public static HashMap<Integer, String> create() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int n, key;
        String name;
        Scanner k = new Scanner(System.in);
        System.out.print("Enter number of employee : ");
        n = Integer.parseInt(k.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name : ");
            name = k.nextLine();
            System.out.print("Enter key : ");
            key = Integer.parseInt(k.nextLine());
            map.put(key, name);
        }
        k.close();
        return map;
    }

    public static void show(HashMap<Integer, String> map) {
        System.out.println("Information of employee");
        for (Integer i : map.keySet()) {
            System.out.println("Name : " + map.get(i));
            System.out.println("Key : " + i);
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map = create();
        show(map);
    }
}
