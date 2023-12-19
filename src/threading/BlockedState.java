package threading;

public class BlockedState {
    static Thread t1, t2;
    static final Object lock = new Object();

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            synchronized (lock) {
                // Simulate some work
                try {
                    Thread.sleep(200);
                    System.out.println("t1 from t1: " + t1.getState());
                    System.out.println("t2 from t1: " + t2.getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 from t2: " + t1.getState());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t2 from t2: " + t2.getState());
            }
        });

        t1.start();
        t2.start();

    }

}
