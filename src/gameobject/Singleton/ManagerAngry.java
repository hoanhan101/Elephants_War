package gameobject.Singleton;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerAngry {
    private static ManagerAngry ourInstance = new ManagerAngry();
    private static boolean has_eat ;
    private static boolean girl_eat ;
    private static boolean old_eat ;
    public static ManagerAngry getInstance() {
        return ourInstance;
    }

    public static boolean isHas_eat() {
        return has_eat;
    }

    public static boolean isGirl_eat() {
        return girl_eat;
    }

    public static void setGirl_eat(boolean girl_eat) {
        ManagerAngry.girl_eat = girl_eat;
    }

    public static boolean isOld_eat() {
        return old_eat;
    }

    public static void setOld_eat(boolean old_eat) {
        ManagerAngry.old_eat = old_eat;
    }

    public static void setHas_eat(boolean has_eat) {
        ManagerAngry.has_eat = has_eat;
    }

    private ManagerAngry() {
    }
}
