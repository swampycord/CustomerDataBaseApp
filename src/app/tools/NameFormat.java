package app.tools;

public class NameFormat {

    public static String firstLetterCapital(String name) {
        String s1 = name.substring(0, 1).toUpperCase();
        String s2 = name.substring(1).toLowerCase();
        return s1 + s2;
    }
}
