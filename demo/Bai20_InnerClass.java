package javademo.demo;

import java.util.Scanner;

public class Bai20_InnerClass {

    public static void main(String[] args) {
        family fm = new family();
        family.grandParents gp = fm.new grandParents();
        gp.input();
        gp.show();
    }
}

class family {

    class grandParents {

        private String grandMother;
        private String grandFather;

        public String getGrandMother() {
            return grandMother;
        }

        public void setGrandMother(String grandMother) {
            this.grandMother = grandMother;
        }

        public String getGrandFather() {
            return grandFather;
        }

        public void setGrandFather(String grandFather) {
            this.grandFather = grandFather;
        }

        public void show() {
            System.out.print("name of grandmother : " + getGrandMother());
            System.out.print("\nname of grandfather : " + getGrandFather());
        }

        public void input() {
            Scanner k = new Scanner(System.in);
            System.out.print("name of grandmother : ");
            setGrandMother(k.nextLine());
            System.out.print("name of grandfather : ");
            setGrandFather(k.nextLine());
            k.close();
        }
    }
}
