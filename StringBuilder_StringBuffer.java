//TODO : StringBuilder and StringBuffer thread safe concept explains using code.

public class StringBuilder_StringBuffer {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
//        StringBuffer sb = new StringBuffer();

        //create two thread that modifies the StringBuilder and StringBuffer instances
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("B");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("B");
            }
        });

        //now start the thread
        t1.start();
        t2.start();

        //wait for both thread to finish
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Print the final result
        System.out.println("Result : " + sb.toString().length());
    }
}
