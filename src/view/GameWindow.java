package view;

import gameobject.Players.Player;
import gameobject.Players.PlayerGirl;
import gameobject.Players.PlayerOld;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hoanhan on 7/13/16.
 */
public class GameWindow extends Frame implements Runnable{
    public static final int windowHeight = 750;
    public static final int windowWidth = 1000;
    public static final int playerHeight = 75;
    public static int Way_1 = 250;
    public static final String Background = "Resource/Background/Background.jpg";
    public static final int count_space = 50;
    public static final int count_repeat = 20;


    Player playerGril ;
    Player playerOld;

    BufferedImage background;
    BufferedImage buffImage ;

    int count_Space_1 = 50;
    int count_Space_2 = 50;

    public GameWindow(){
        initWindow();
        initLoadImage();
        initPlayer();
        initCursor();
        repaint();
    }

    private void initCursor() {
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "cursor"));
    }

    private void initPlayer() {
        playerGril = new PlayerGirl(0,Way_1 - playerHeight,PlayerGirl.TYPE_PLAYER_GIRL);
        playerOld = new PlayerOld(900,Way_1 - playerHeight,PlayerOld.TYPE_PLAYER_OLD);
    }

    private void initLoadImage() {
        try {
            background = ImageIO.read(new File(Background));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWindow() {
        this.setTitle("War Elephant");
        this.setSize(windowWidth,windowHeight);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventKeyType(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                eventKeyCode(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void eventKeyCode(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if(count_Space_1 >= count_space){
                    playerOld.call();
                    count_Space_1 = 0;
                }
        }
    }

    private void eventKeyType(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'd':
                if(count_Space_2 >= count_space) {
                    playerGril.call();
                    count_Space_2 = 0;
                }
            break;
            default: break;
        }
    }

    public void gameUpdate(){
        count_Space_1++;
        count_Space_2++;

        playerGril.update(1);
        playerOld.update(2);

        if(playerGril.listElephant.size() > 0 && playerOld.listElephant.size() > 0)
            playerGril.checkCollision(playerOld);

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
        bufferGraphic.drawImage(background,0,0,null);

        playerGril.draw(bufferGraphic);
        playerOld.draw(bufferGraphic);

        g.drawImage(buffImage,0,0,null);
    }

    @Override
    public void run() {
        gameLoop();
    }
}
