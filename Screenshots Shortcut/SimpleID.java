public class SimpleID {
    private static int counter = 1234;

    public static String generate() {
        return Integer.toString(counter++);
    }
}
