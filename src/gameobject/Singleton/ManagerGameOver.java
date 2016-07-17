package gameobject.Singleton;

/**
 * Created by HP on 7/17/2016.
 */
public class ManagerGameOver {
    private static ManagerGameOver ourInstance = new ManagerGameOver();
    private static int a ;
    public static ManagerGameOver getInstance() {
        return ourInstance;
    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        ManagerGameOver.a = a;
    }

    private ManagerGameOver() {
    }
}
