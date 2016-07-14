package gameobject;

import view.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Elephant {
    public static final int TYPE_ELEPHANT_1 = 1;
    public static final int TYPE_ELEPHANT_2 = 2;
    public static final int TYPE_ELEPHANT_3 = 3;
    public static final int TYPE_ELEPHANT_4 = 4;
    public static final int TYPE_ELEPHANT_5 = 5;
    public static final int TYPE_ELEPHANT_6 = 6;

    public static final String ELEPHANT_BIG = "Resource/Char/1Boss.png";
    public static final String ELEPHANT_MID = "Resource/Char/1Angry.png";
    public static final String ELEPHANT_SMALL = "Resource/Char/1Blue.png";

    public static int Way_1 = 250;

    public static final int HP_ELEPHANT_1 = 100;
    public static final int HP_ELEPHANT_2 = 200;
    public static final int HP_ELEPHANT_3 = 300;

    public int posY;
    public int type;
    public Animation animation;

    private BufferedImage sprite;
    private int posX;
    private int speed;
    private int strength;

    boolean hasCollision = false;

    public Elephant(int posX,int type,int speed) {
        this.speed = speed;
        this.posX = posX;
        this.type = type;
        loadSpriteByType(type);
    }

    private void loadSpriteByType(int type) {
        switch (type) {
            case TYPE_ELEPHANT_1:
                loadAnimation(1,ELEPHANT_SMALL,HP_ELEPHANT_1);
                break;
            case TYPE_ELEPHANT_2:
                loadAnimation(2,ELEPHANT_MID,HP_ELEPHANT_2);
                break;
            case TYPE_ELEPHANT_3:
                loadAnimation(3,ELEPHANT_BIG,HP_ELEPHANT_3);
                break;
            case TYPE_ELEPHANT_4:
                loadAnimation(4,ELEPHANT_SMALL,HP_ELEPHANT_1);
                break;
            case TYPE_ELEPHANT_5:
                loadAnimation(5,ELEPHANT_MID,HP_ELEPHANT_2);
                break;
            case TYPE_ELEPHANT_6:
                loadAnimation(6,ELEPHANT_BIG,HP_ELEPHANT_3);
                break;
        }
    }

    private void loadAnimation(int x,String str,int strength){
        try {
            sprite = ImageIO.read(new File(str));
            animation = new Animation(x,20,31);
            this.strength = strength;
        } catch (IOException e) {
            e.printStackTrace();
        }
        posY = getHeightSprite();
    }

    private void getPosXAnimation(){
        animation.setPosX(this.posX);
        animation.setPosY(this.posY);
        animation.setStrength(this.strength);
    }

    private int getHeightSprite(){
        return Way_1 - sprite.getHeight();
    }


    private void position(int x) {
        posX = x;
    }

    public void  moveByVector() {
        posX += speed ;
    }

    void update(){
        moveByVector();
        animation.update();
        getPosXAnimation();
    }

    public void draw(Graphics g){
        animation.draw(g,posX,posY);
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
