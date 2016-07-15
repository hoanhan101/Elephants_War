package gameobject.Menu;

/**
 * Created by HP on 7/15/2016.
 */
public class ManagerWay {
    private static ManagerWay ourInstance = new ManagerWay();
    private static int Way;
    public static ManagerWay getInstance() {
        return ourInstance;
    }

    public static void setWay(int way) {
        Way = way;
    }

    public static int getWay() {
        return Way;
    }

    private ManagerWay() {
    }
}
