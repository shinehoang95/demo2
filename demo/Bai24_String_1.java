package javademo.demo;

import java.io.DataInputStream;

class InputData {

    static DataInputStream str = new DataInputStream(System.in);

    @SuppressWarnings("deprecation")
    public static String InputString() {
        String st = null;
        try {
            st = str.readLine();
        } catch (Exception e) {
            System.out.print("Error!" + e.toString());
        }
        return st;
    }

    public static int InputInt() {
        String st = null;
        st = InputData.InputString();
        int i = 0;
        try {
            i = Integer.valueOf(st).intValue();
        } catch (Exception e) {
            System.out.print("Error!" + e.toString());
        }
        return i;
    }

}

public class Bai24_String_1 {

    public static void main(String[] args) {
        String[] name = null;
        System.out.print("nhap so nguoi:");
        int n = InputData.InputInt();
        name = new String[n];
        for (int i = 0; i < name.length; i++) {
            System.out.print("Nhap ten nguoi thu " + (i + 1) + ": ");
            name[i] = InputData.InputString().trim().toUpperCase();
        }
        System.out.println("Danh sach ten: ");
        for (int i = 0; i < name.length; i++) {
            System.out.println(+(i + 1) + ".    " + name[i]);
        }
        System.out.println("Ten nhung nguoi ho Nguyen: ");
        for (int i = 0; i < name.length; i++) {
            if (name[i].substring(0, 6).equals("NGUYEN")) {
                System.out.println(name[i]);
            }
        }
    }
}
