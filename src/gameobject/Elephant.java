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

    public static final String ELEPHANT_BIG = "Resource/Char/1Boss.png";
    public static final String ELEPHANT_SMALL = "Resource/Char/1Blue.png";
    public static final String ELEPHANT_MID = "Resource/Char/1Angry.png";

    public int posY;

    private Animation animation;
    private BufferedImage sprite;
    private int posX;
    private int speed;
    private int strength;

    public Elephant(int posX,int type,int speed) {
        this.speed = speed;
        this.posX = posX;
        loadSpriteByType(type);
    }

    private void loadSpriteByType(int type) {
        switch (type) {
            case TYPE_ELEPHANT_1:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_BIG));
                    animation = new Animation(1,20,31);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                posY = getHeightSprite();
                break;
           case TYPE_ELEPHANT_2:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_SMALL));
                    animation = new Animation(2,20,31);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                posY = getHeightSprite();
                break;
            case TYPE_ELEPHANT_3:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_MID));
                    animation = new Animation(3,20,31);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                posY = getHeightSprite();
                break;

        }
    }

    private int getHeightSprite(){
        return 350 - sprite.getHeight();
    }


    private void position(int x) {
        posX = x;
    }

    public void  moveByVector() {
        posX += speed ;
    }

    void update(){
        moveByVector();
        try {
            animation.update();
        }catch (Exception e){

        }
//        Iterator<BufferedImage> cursorImage = animation.frames.iterator();
//        while (cursorImage.hasNext()){
//            if(posX > 100000000) cursorImage.remove();
//        }
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
