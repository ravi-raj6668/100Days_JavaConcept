class Display {
    public synchronized void wish(String name) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Testing the code : " + name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Getting exception {} : " + e.getMessage() + name);
            }
        }
    }
}

class MyThreadT extends Thread {
    Display d;
    String name;

    MyThreadT(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.wish(name);
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) {
        Display d = new Display();
        MyThreadT t1 = new MyThreadT(d, "Java");
        MyThreadT t2 = new MyThreadT(d, "SpringBoot");
        t1.start();
        t2.start();
    }
}
