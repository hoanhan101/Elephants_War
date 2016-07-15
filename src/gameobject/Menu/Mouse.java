package gameobject.Menu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 7/15/2016.
 */
public class Mouse {
    public static final String MOUSE = "Resource/Char101/mouse/mouse.png";
    public static final String HAND = "Resource/Char101/mouse/hand.png";

    private int posX = 0;
    private int posY = 0;
    private BufferedImage sprite ;
    private BufferedImage spriteHand;
    boolean hasCollision = false;

    public Mouse(){

    }
    public Mouse(int posX,int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public Rectangle getRectangleButton(){
        return new Rectangle(posX, posY, 25, 25);
    }
    public void draw(Graphics g){
        try {
            sprite = ImageIO.read(new File(MOUSE));
            spriteHand = ImageIO.read(new File(HAND));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(hasCollision){
            g.drawImage(spriteHand,posX,posY,null);
        }else {
            g.drawImage(sprite, posX, posY, null);
        }
    }

    public void update(){

    }
    public boolean isHasCollision() {
        return hasCollision;
    }

    public void setHasCollision(boolean hasCollision) {
        this.hasCollision = hasCollision;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage getSpriteHand() {
        return spriteHand;
    }

    public void setSpriteHand(BufferedImage spriteHand) {
        this.spriteHand = spriteHand;
    }
}
