package gameobject.Singleton;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerOld {
    private static ManagerOld ourInstance = new ManagerOld();
    private static int animationOld;
    public static ManagerOld getInstance() {
        return ourInstance;
    }

    public static int getAnimationOld() {
        return animationOld;
    }

    public static void setAnimationOld(int animationOld) {
        ManagerOld.animationOld = animationOld;
    }

    private ManagerOld() {
    }
}
