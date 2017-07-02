package javademo.demo;

//Thread 1
public class Unit54_Thread {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Lam");
                    Thread.sleep(500);
                    System.out.println("Nguyen");
                } catch (InterruptedException e) {
                }
            }
        };
        for (int i = 0; i < 5; i++) {
            System.out.println("i=" + i);
            thread.run();
        }
        thread.run();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Lam");
            Thread.sleep(1000);
            System.out.println("Nguyen");
        } catch (InterruptedException e) {
        }
    }
}

class YourThread implements Runnable {

    @Override
    public void run() {

    }
}
