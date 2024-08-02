package Singleton;
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Logged: " + message);
    }

    public static void main(String[] args) {
        Singleton logger1 = Singleton.getInstance();
        logger1.log("This is a log message");

        Singleton logger2 = Singleton.getInstance();
        logger2.log("This is another log message");

        System.out.println("logger1 == logger2: " + (logger1 == logger2));
    }
}
