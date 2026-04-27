import java.util.concurrent.Executors;

/**
 * Demonstrates the different ways to create and run Virtual Threads in Java.
 * Virtual threads are lightweight and ideal for blocking tasks.
 */
public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        // The task we want to run
        Runnable task = () -> {
            String type = Thread.currentThread().isVirtual() ? "Virtual" : "Platform";
            System.out.println(type + " thread working: " + Thread.currentThread().getName());
        };

        // 1. Using Thread.startVirtualThread(Runnable)
        // This is the fastest "fire and forget" way to start a virtual thread.
        Thread.startVirtualThread(task);

        // 2. Using Thread.ofVirtual()
        // This allows more configuration, like setting a name or starting the thread
        // later.
        Thread vThread = Thread.ofVirtual()
                .name("custom-vt-", 1)
                .unstarted(task);

        vThread.start();
        vThread.join(); // Wait for it to finish

        // 3. Using ExecutorService (Recommended for handling many tasks)
        // try-with-resources ensures the executor closes and all tasks finish.
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(task);
            executor.submit(task);
        }

        // 4. Checking if a thread is Virtual
        checkThreadType(vThread);
        checkThreadType(Thread.currentThread());

        // check java 22 feature: multi file source code
        System.out.println(DepClass.count);
    }

    /**
     * Helper to demonstrate the isVirtual() check.
     */
    private static void checkThreadType(Thread thread) {
        if (thread.isVirtual()) {
            System.out.println(thread.getName() + " IS a virtual thread.");
        } else {
            System.out.println(thread.getName() + " IS NOT a virtual thread (Platform thread).");
        }
    }
}
