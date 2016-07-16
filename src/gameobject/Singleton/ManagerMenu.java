package gameobject.Singleton;

import gameobject.Menu.Screen;

import java.util.Stack;

/**
 * Created by HP on 7/15/2016.
 */
public class ManagerMenu {
    private static ManagerMenu ourInstance = new ManagerMenu();

    private Stack<Screen> stackScreen;

    public static ManagerMenu getInstance() {
        return ourInstance;
    }

    public Stack<Screen> getStackScreen(){
        return stackScreen;
    }

    private ManagerMenu() {
        stackScreen = new Stack<>();
    }
}
