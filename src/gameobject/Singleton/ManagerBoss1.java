package gameobject.Singleton;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerBoss1 {
    private static ManagerBoss1 ourInstance = new ManagerBoss1();
    private static boolean has_eat ;
    private static boolean girl_eat ;
    private static boolean old_eat ;
    public static ManagerBoss1 getInstance() {
        return ourInstance;
    }

    public static boolean isGirl_eat() {
        return girl_eat;
    }

    public static void setGirl_eat(boolean girl_eat) {
        ManagerBoss1.girl_eat = girl_eat;
    }

    public static boolean isOld_eat() {
        return old_eat;
    }

    public static void setOld_eat(boolean old_eat) {
        ManagerBoss1.old_eat = old_eat;
    }

    public static boolean isHas_eat() {
        return has_eat;
    }

    public static void setHas_eat(boolean has_eat) {
        ManagerBoss1.has_eat = has_eat;
    }

    private ManagerBoss1() {
    }
}
