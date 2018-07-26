public class IDCreator {

    private int id = 0;

    public  int generateNewID() {
        return id++;
    }

    private static IDCreator ourInstance = new IDCreator();

    public static IDCreator getInstance() {
        return ourInstance;
    }


    private IDCreator() {
    }
}
