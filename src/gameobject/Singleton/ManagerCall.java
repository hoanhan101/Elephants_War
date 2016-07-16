package gameobject.Singleton;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerCall {
    private static ManagerCall ourInstance = new ManagerCall();
    private static int before;
    private static int beforeMan;

    public static int getBeforeMan() {
        return beforeMan;
    }

    public static void setBeforeMan(int beforeMan) {
        ManagerCall.beforeMan = beforeMan;
    }

    public static ManagerCall getInstance() {
        return ourInstance;
    }

    public static int getBefore() {
        return before;
    }

    public static void setBefore(int before) {
        ManagerCall.before = before;
    }

    private ManagerCall() {
    }
}
