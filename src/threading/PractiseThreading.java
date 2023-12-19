package threading;

public class PractiseThreading {
    static Thread t1, t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            t2 = new Thread(() -> {
                try {
                    Thread.sleep(1000);// timed sleeping
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                    System.out.println("t1 state while joining "+ t1.getState());
            });
            System.out.println("creating t2 " + t2.getState());
            t2.start();
            System.out.println("starting t2: "+ t2.getState());
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2 after join " + t2.getState());

        });
        t1.start();
    }
}
