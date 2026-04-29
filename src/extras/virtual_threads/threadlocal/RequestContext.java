package threadlocal;

class RequestContext {
    private static final ThreadLocal<String> USER = new ThreadLocal<>();

    public static void setUser(String user) {
        USER.set(user);
    }

    public static String getUser() {
        return USER.get();
    }

    public static void clear() {
        USER.remove();
    }
}
