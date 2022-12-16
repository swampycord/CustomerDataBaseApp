package app.tools;

public class AppConsole {

    public  AppConsole () {}

    public static void clear() {
        for(int clear = 0; clear < 10; clear++) {
            System.out.println("\b") ;
        }
    }
}
