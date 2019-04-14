package servlets;

public class n {
    private static n ourInstance = new n();

    public static n getInstance() {
        return ourInstance;
    }

    private n() {
    }
}
