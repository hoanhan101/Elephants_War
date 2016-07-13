package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Player {
    public static final int TYPE_PLAYER_1 = 1;
    public static final int TYPE_PLAYER_2 = 2;

    public static final String PLAYER_GIRL = "Resource/Char/1Girl.png";
    public static final String PLAYER_OLDMAN = "Resource/Char/2OldMan.png";

    private BufferedImage sprite;
    private int posX;
    private int posY;


    public ArrayList<Elephant> listElephant = new ArrayList<Elephant>();

    Random random = new Random();

    public Player(int posX,int posY, int type){
        this.posX = posX;
        this.posY = posY;
        loadSpriteByType(type);
    }


    private void loadSpriteByType(int type) {
        switch (type) {
            case TYPE_PLAYER_1:
                try {
                    sprite = ImageIO.read(new File(PLAYER_GIRL));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case TYPE_PLAYER_2 :
                try {
                    sprite = ImageIO.read(new File(PLAYER_OLDMAN));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void call(){
        int x = random.nextInt(3);
        listElephant.add(new Elephant(0,x+1,7));
    }

    public void draw(Graphics g){
        g.drawImage(sprite,posX, posY,null);
        Iterator<Elephant> cursorElephant = listElephant.iterator();
        while(cursorElephant.hasNext()){
            try {
                cursorElephant.next().draw(g);
            }catch (ConcurrentModificationException e){

            }
        }
    }
    public void update (){
        Iterator<Elephant> cursorElephant = listElephant.iterator();
        while (cursorElephant.hasNext()){
            Elephant elephant = cursorElephant.next();
            elephant.update();
            if(elephant.getPosX() > 1100) cursorElephant.remove();
            if(elephant.getPosX() < -100) cursorElephant.remove();
        }
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
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

}
