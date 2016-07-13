package view;

import gameobject.Player;
import gameobject.PlayerGirl;

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
    public static final int windowHeight = 480;
    public static final int windowWidth = 640;
    public static int positionWay_Y = 350;
    public static final String Background = "Resource/Background/Background.jpg";


    Player playerGril ;
    BufferedImage background;
    BufferedImage buffImage ;

    int count_Space = 100;

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
        playerGril = new PlayerGirl(positionWay_Y - 75,Player.TYPE_PLAYER_1);
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

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void eventKeyType(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'd':
                if(count_Space >= 100) {
                    playerGril.call();
                    count_Space = 0;
                }
            break;
            default: break;
        }
    }

    public void gameUpdate(){
        count_Space++;
        playerGril.update();
    }

    public void gameLoop(){
        while(true){
            gameUpdate();
            repaint();
            try {
                Thread.sleep(20);
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

        g.drawImage(buffImage,0,0,null);
    }

    @Override
    public void run() {
        gameLoop();
    }
}
