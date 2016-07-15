package gameobject.Menu;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerWay2 {
    private static ManagerWay2 ourInstance = new ManagerWay2();
    private static int Way2;
    public static ManagerWay2 getInstance() {
        return ourInstance;
    }
    public static int getWay() {
        return Way2;
    }
    public static void setWay(int way) {
        Way2 = way;
    }
    private ManagerWay2() {
    }
}
