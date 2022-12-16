package app.tools;

public class CustomThread {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }

//    public static void waiting(long millis) {
//        try {
//            w
//        } catch (InterruptedException e) {
//            e.fillInStackTrace();
//        }
//    }
}
