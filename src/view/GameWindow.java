package view;

import gameobject.Menu.FirstBackground;
import gameobject.Menu.GamePlay;
import gameobject.Menu.ManagerMenu;
import gameobject.Menu.Mouse;
import gameobject.Players.Player;
import gameobject.Players.PlayerGirl;
import gameobject.Players.PlayerOld;
import javafx.stage.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hoanhan on 7/13/16.
 */
public class GameWindow extends Frame implements Runnable{
    public static final int windowHeight = 700;
    public static final int windowWidth = 1000;

    public static final int count_repeat = 20;

    int collision;

    BufferedImage buffImage ;

    Mouse mouse = new Mouse();

    public GameWindow(){
        initWindow();
        initCursor();
        repaint();
    }

    private void initCursor() {
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "cursor"));
    }



    private void initWindow() {
        this.setTitle("War Elephant");
        this.setSize(windowWidth,windowHeight);
        this.setVisible(true);
        ManagerMenu.getInstance().getStackScreen().push(new FirstBackground());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               ProgressClickLeft(e.getButton());
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                ProgressMouseMove(e);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventKeyType(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void checkCollision(Mouse mouse){
        collision = ManagerMenu.getInstance().getStackScreen().peek().Collision(mouse);
        if(collision == 1) mouse.setHasCollision(true);
        if(collision == 0) mouse.setHasCollision(false);
    }
    private void ProgressMouseMove(MouseEvent e) {
        mouse = new Mouse(e.getX(),e.getY());
    }

    private void ProgressClickLeft(int button) {
        if(button == 1){
            ManagerMenu.getInstance().getStackScreen().peek().clickButton(mouse);
        }
    }

    private void eventKeyType(KeyEvent e) {
        if((ManagerMenu.getInstance().getStackScreen().peek()) instanceof GamePlay) {
            ((GamePlay) ManagerMenu.getInstance().getStackScreen().peek()).initPlay(e.getKeyChar());
        }
    }

    public void gameUpdate(){

       ManagerMenu.getInstance().getStackScreen().peek().update();
        checkCollision(mouse);
        mouse.update();
    }

    public void gameLoop(){
        while(true){
            gameUpdate();
            repaint();
            try {
                Thread.sleep(count_repeat);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(Graphics g) {
        if(buffImage == null) {
            buffImage = new BufferedImage(windowWidth, windowHeight, 1);
        }
        Graphics bufferGraphic = buffImage.getGraphics();

        ManagerMenu.getInstance().getStackScreen().peek().draw(bufferGraphic);
        mouse.draw(bufferGraphic);

        g.drawImage(buffImage,0,0,null);
    }

    @Override
    public void run() {
        gameLoop();
    }
}
