package javademo.demo;

public class Unit27_Static {

    public static void main(String[] args) {
        Room r1 = new Room();
        r1.number = 10;
        System.out.println("R1 number = " + r1.number);
        Room r2 = new Room();
        
        System.out.println("R2 number = " + r2.number);

        Room r3 = new Room();
        System.out.println("R3 number = " + r3.number);
    }
}

class Room {

    static int number;
    static int area;
}