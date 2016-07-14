package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Elephant {

    public static int Way_1 = 250;

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

    protected void loadSpriteByType(int type) {
    }

    protected void loadAnimation(int x,String str,int strength){
        try {
            sprite = ImageIO.read(new File(str));
            addAnimation(x);
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

    private void addAnimation(int x){
        if(x == 1 || x == 11)
            animation = new AnimationBlue(x,31);
        if(x == 2 || x == 12)
            animation = new AnimationAngry(x,31);
        if(x == 3 || x == 13)
            animation = new AnimationBoss1(x,31);
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
