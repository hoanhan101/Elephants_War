package gameobject;

import view.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Elephant {
    public static final int TYPE_ELEPHANT_1 = 1;
    public static final int TYPE_ELEPHANT_2 = 2;
    
    public static final String ELEPHANT_BIG_1 = "Resource/Char/1Boss.png";
    public static final String ELEPHANT_BIG_2 = "Resource/Char/2Boss.png";

    private BufferedImage sprite;
    private int posX;
    private int speed;
    private int strength;

    public Elephant(int posX, int type,int speed) {
        this.speed = speed;
        this.posX = posX;
        loadSpriteByType(type);
    }

    private void loadSpriteByType(int type) {
        switch (type) {
            case 1:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_BIG_1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_BIG_2));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    private void position(int x) {
        posX = x;
    }

    public void  moveByVector() {
        posX += speed ;
    }

    void update(){
        moveByVector();
    }

    public void draw(Graphics g){
        g.drawImage(sprite,posX, GameWindow.windowHeight/2,null);
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
