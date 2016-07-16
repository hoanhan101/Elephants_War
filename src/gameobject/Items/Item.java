package gameobject.Items;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by HP on 7/16/2016.
 */
public class Item  {
    public static final String SKILL_ANGRY = "Resource/Char101/AnimalSkill/SkillAngry.png";
    public static final String SKILL_BOSS1 = "Resource/Char101/AnimalSkill/SkillBoss.png";
    public static final String SKILL_BOSS2 = "Resource/Char101/AnimalSkill/SkillBoss2.png";
    public static final String SKILL_BOSS3 = "Resource/Char101/AnimalSkill/SkillFire.png";

    public int posX;
    public int posY;
    public int speed;

    public static BufferedImage angry;
    public static BufferedImage boss1;
    public static BufferedImage boss2;
    public static BufferedImage boss3;
    public static BufferedImage sprite;

    Random randow = new Random();
    int x,z = 0 ;
    public Item(){

    }
    public Item(int posX,int posY,int speed){
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        loadImage();
    }

    private void loadImage() {
        try {
            angry = ImageIO.read(new File(SKILL_ANGRY));
            boss1 = ImageIO.read(new File(SKILL_BOSS1));
            boss2 = ImageIO.read(new File(SKILL_BOSS2));
            boss3 = ImageIO.read(new File(SKILL_BOSS3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = randow.nextInt(4);
        if(x  == 0) sprite = angry;
        if(x  == 1) sprite = boss1;
        if(x  == 2) sprite = boss2;
        if(x  == 3) sprite = boss3;
    }

    public Rectangle getRectangle(){
        return new Rectangle(posX,posY,sprite.getWidth(),sprite.getHeight());
    }
    public void update(){
        posX += speed;
        if(posX == 600 && z == 0){
            speed = 0;
            posY = (randow.nextInt(5)+2)*100-sprite.getHeight();
            z++;
        }
    }
    public void draw(Graphics g,BufferedImage image){
       g.drawImage(image,posX,posY,null);
    }
}
