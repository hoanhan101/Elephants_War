package gameobject.Singleton;

/**
 * Created by HP on 7/16/2016.
 */
public class ManagerGirl {
    private static ManagerGirl ourInstance = new ManagerGirl();
    private static int animationGirl;
    public static ManagerGirl getInstance() {
        return ourInstance;
    }

    private ManagerGirl() {
    }

    public static int getAnimationGirl() {
        return animationGirl;
    }

    public static void setAnimationGirl(int animationGirl) {
        ManagerGirl.animationGirl = animationGirl;
    }
}
