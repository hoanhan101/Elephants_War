package gameobject;

import view.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

                } catch (IOException e) {
                    e.printStackTrace();
                }

                posY = getHeightSprite();
                break;
           case TYPE_ELEPHANT_2:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_SMALL));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                posY = getHeightSprite();
                break;
            case TYPE_ELEPHANT_3:
                try {
                    sprite = ImageIO.read(new File(ELEPHANT_MID));
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

    private void flipImage(){
        AffineTransform tx = AffineTransform.getScaleInstance(-1,1);
        tx.translate(-sprite.getWidth(null),0);
        AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        sprite = op.filter(sprite,null);
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
        g.drawImage(sprite,posX,posY,null);
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
