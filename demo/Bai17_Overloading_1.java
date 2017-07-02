package javademo.demo;
//Overloading

class Hinh {
 
    public float dienTich(float a) {
        return (float) a * a;
    }
 
    public float dienTich(float a, float b) {
        return (float) a * b;
    }
 
    public double dienTich(float a, float b, float c) {
        float p;
        p = (float) (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
 
public class Bai17_Overloading_1 {
 
    public static void main(String[] args) {
        Hinh h = new Hinh();
        System.out.println("Diện tích hình vuông có cạnh 2 : " + h.dienTich(2));
        System.out.println("Diện tích hình chữ nhật có 2 cạnh là 4 và 5 : " + h.dienTich(4, 5));
        System.out.println("Diện tích hình tam giác có 3 cạnh là 3, 4, 5 : " + h.dienTich(3, 4, 5));
    }
}
