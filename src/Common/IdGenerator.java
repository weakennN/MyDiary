package Common;

public class IdGenerator {

    private static int id = 0;

    public static int generateId() {
        return ++id;
    }
}
