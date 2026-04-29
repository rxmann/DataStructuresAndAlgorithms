package threadlocal;

import java.lang.ScopedValue;

public class ScopedExample {

    private static final ScopedValue<String> USER = ScopedValue.newInstance();

    public static void main(String[] args) {

        ScopedValue.where(USER, "Alice").run(() -> {
            handleRequest();
        });

        ScopedValue.where(USER, "Bob").run(() -> {
            handleRequest();
        });
    }

    static void handleRequest() {
        serviceLayer();
    }

    static void serviceLayer() {
        System.out.println("User = " + USER.get());
    }
}