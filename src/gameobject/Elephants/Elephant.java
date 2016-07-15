package gameobject.Elephants;

import gameobject.Animations.*;

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
    public Animation animation = new Animation();
    private int check_Collision = 0;
    private BufferedImage sprite;
    private int posX;
    private int speed;
    private int strength;

    public boolean hasCollision = false;

    public Elephant(int posX,int type,int speed) {
        this.speed = speed;
        this.posX = posX;
        this.type = type;
        loadSpriteByType(type);
    }

    public Elephant(){
    }
    protected void loadSpriteByType(int type) {
    }

    protected void loadAnimation(int x,String str,int strength){
        try {
            sprite = ImageIO.read(new File(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addAnimation(x);
            this.strength = strength;

        posY = getHeightSprite();
    }

    private void getPosXAnimation(){
        animation.setPosX(this.posX);
        animation.setPosY(this.posY);
        animation.setStrength(this.strength);
        if(check_Collision == 0 && hasCollision) {
            animation.setHasCollision(this.hasCollision);
            check_Collision++;
        }
        animation.setType(this.type);
    }

    private void addAnimation(int x){
        if(x == 1 || x == 11)
            animation = new AnimationBlue(x,31);
        if(x == 2 || x == 12)
            animation = new AnimationAngry(x,31);
        if(x == 3 || x == 13)
            animation = new AnimationBoss1(x,31);
        if(x == 4 || x == 14)
            animation = new AnimationBoss2(x,31);
        if(x == 5 || x == 15)
            animation = new AnimationBrown(x,31);
        if(x == 6 || x == 16)
            animation = new AnimationStupid(x,31);
        if(x == 7 || x == 17)
            animation = new AnimationBigBrown(x,31);
        if(x == 8 || x == 18)
            animation = new AnimationGreen(x,31);
        if(x == 9 || x == 19)
            animation = new AnimationPink(x,31);
    }

    private int getHeightSprite(){
        return Way_1 - sprite.getHeight();
    }

    public void  moveByVector() {
        posX += speed ;
    }

    public void update(){
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

    public int getCheck_Collision() {
        return check_Collision;
    }

    public void setCheck_Collision(int check_Collision) {
        this.check_Collision = check_Collision;
    }

    public boolean isHasCollision() {
        return hasCollision;
    }

    public void setHasCollision(boolean hasCollision) {
        this.hasCollision = hasCollision;
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
