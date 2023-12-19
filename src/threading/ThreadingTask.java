package threading;

public class ThreadingTask {
    static int[] arr = {1242, 45643, 2456, 1456, 87654, 1387, 16789};
    static long sequenceTime;
    static long parallelTime;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("parallel Sum: " + sum());

        });
        Thread t2 = new Thread(() -> {
            System.out.println("parallel product: " + product());
        });
        long start = System.nanoTime();
        t1.start();
        t2.start();
        parallelTime = System.nanoTime() - start;
        System.out.println("parallel time : " + parallelTime);

        // sequence
        long startSeq = System.nanoTime();
        System.out.println("seq Sum: " + sum());
        System.out.println("seq product: " + product());
        System.out.println("seq time: " + (System.nanoTime() - startSeq));

    }

    public static int product() {
        int product = 1;
        for (int i : arr) {
            product *= i;
        }
        return product;
    }

    public static int sum() {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }


}
