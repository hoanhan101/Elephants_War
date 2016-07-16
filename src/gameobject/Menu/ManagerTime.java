package gameobject.Menu;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerTime {
    private static ManagerTime ourInstance = new ManagerTime();
    private static int time;
    public static ManagerTime getInstance() {
        return ourInstance;
    }

    private ManagerTime() {
    }

    public static int getTime() {
        return time;
    }

    public static void setTime(int time) {
        ManagerTime.time = time;
    }
}
