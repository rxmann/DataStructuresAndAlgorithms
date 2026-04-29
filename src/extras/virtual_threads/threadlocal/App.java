package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {

        Runnable request1 = () -> {
            try {
                RequestContext.setUser("Alice");
                handleRequest();
            } finally {
                RequestContext.clear(); // MUST
            }
        };

        Runnable request2 = () -> {
            try {
                RequestContext.setUser("Bob");
                handleRequest();
            } finally {
                RequestContext.clear();
            }
        };

        new Thread(request1).start();
        new Thread(request2).start();

        ExecutorService pool = Executors.newFixedThreadPool(1);

        pool.submit(() -> {
            RequestContext.setUser("Alice");
            System.out.println(RequestContext.getUser());
            // forgot clear ❌
            RequestContext.clear();
        });

        pool.submit(() -> {
            System.out.println(RequestContext.getUser()); // 💥 STILL Alice
        });

        pool.shutdown();

    }

    static void handleRequest() {
        serviceLayer();
    }

    static void serviceLayer() {
        System.out.println("User = " + RequestContext.getUser());
    }
}
