package threadlocal;

public class ThreadLocalEx {

    private static final ThreadLocal<Double> PI = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        PI.set(3.14159);
        System.out.println("Main Thread PI: " + PI.get());

        Thread thx = new Thread(() -> {
            System.out.println("Child Thread PI (before set): " + PI.get());

            PI.set(3.0);
            System.out.println("Child Thread PI (after set): " + PI.get());
        });

        Thread thz = new Thread(() -> {
            System.out.println("Child Thread Z PI (before set): " + PI.get());

            PI.set(4.0);
            System.out.println("Child Thread Z PI (after set): " + PI.get());
        });

        thx.start();
        thz.start();

        thx.join();
        thz.join();

        System.out.println("Main Thread PI (still): " + PI.get());

        PI.remove();
    }
}
