package main;

import view.GameWindow;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
