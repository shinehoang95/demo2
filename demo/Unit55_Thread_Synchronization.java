package javademo.demo;

//Thread 2 + Synchronization
public class Unit55_Thread_Synchronization {

    public static void main(String[] args) {
        Thread55 thread55 = new Thread55();
        Thread55a thread55a = new Thread55a();

        Thread thread1 = new Thread(thread55);
        Thread thread2 = new Thread(thread55);
        Thread thread3 = new Thread(thread55a);

        thread1.setName("thread 1 : ");
        thread2.setName("thread 2 : ");
        thread3.setName("thread 3 : ");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Thread55 implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (Exception e) {
            }
        }
    }
}

class Thread55a implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
//                System.out.println("---");
                System.out.println(Thread.currentThread().getName() + " " + i);
            } catch (Exception e) {
            }
        }
    }
}
