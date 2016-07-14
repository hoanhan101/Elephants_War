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

    private static final int SPEED_UPDATE_GIRL = -1;
    private static final int SPEED_UPDATE_OLDMAN = 1;

    private BufferedImage sprite;
    private int posX;
    private int posY;
    private static int sumElephantGirl ;
    private static int sumElephantMan ;

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
    }

    public void draw(Graphics g){
        g.drawImage(sprite,posX, posY,null);

        Iterator<Elephant> cursorElephant = listElephant.iterator();
        while(cursorElephant.hasNext()){
            try {
                cursorElephant.next().draw(g);
            }catch (Exception e){

            }
        }
    }
    public void update (int x){
        Iterator<Elephant> cursorElephant = listElephant.iterator();
        while (cursorElephant.hasNext()){
            Elephant elephant = cursorElephant.next();
            elephant.update();
            if(elephant.getPosX() > 900){
                changeSumPlayer(x,elephant);
                cursorElephant.remove();
            }
            if(elephant.getPosX() < 0){
                changeSumPlayer(x,elephant);
                cursorElephant.remove();
            }
        }
    }

    private void changeSumPlayer(int x,Elephant elephant){
        if(x == 1) {
            sumElephantGirl -= elephant.getStrength();
            if (sumElephantGirl < 0) sumElephantGirl = 0;
        }
        if(x == 2) {
            sumElephantMan -= elephant.getStrength();
            if (sumElephantMan < 0) sumElephantMan = 0;
        }
    }
    public void checkCollision(Player player){
        for(int i = 0 ; i < listElephant.size() ; i++) {
            for (int j = 0; j < player.listElephant.size() ; j++) {
                try {
                    if (listElephant.get(i).animation.getRectangle().intersects(player.listElephant.get(j).animation.getRectangle())) {
                        if (listElephant.get(i).hasCollision == false)
                            sumElephantGirl += listElephant.get(i).getStrength();
                        if (player.listElephant.get(j).hasCollision == false)
                            sumElephantMan += player.listElephant.get(j).getStrength();

                        listElephant.get(i).hasCollision = true;
                        player.listElephant.get(j).hasCollision = true;

                        if (sumElephantGirl < sumElephantMan) {
                            changeSpeedCollision(SPEED_UPDATE_GIRL,player);
                        }
                        if (sumElephantMan < sumElephantGirl) {
                            changeSpeedCollision(SPEED_UPDATE_OLDMAN,player);
                        }
                        if (sumElephantMan == sumElephantGirl) {
                            changeSpeedCollision(0,player);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private void changeSpeedCollision(int x,Player player){
        for(int k = 0; k < listElephant.size(); k++)
            if(listElephant.get(k).hasCollision) listElephant.get(k).setSpeed(x);
        for(int k = 0; k < player.listElephant.size(); k++)
            if(player.listElephant.get(k).hasCollision) player.listElephant.get(k).setSpeed(x);
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
    public int checkType(int x){
        if(x == 1 || x == 4) return 300;
        if(x == 2 || x == 5) return 100;
        if(x == 3 || x == 6) return 200;
        return 0;
    }
    public int getSumElephantGirl() {
        return sumElephantGirl;
    }
    public void setSumElephantGirl(int sumElephantGirl) {
        this.sumElephantGirl = sumElephantGirl;
    }
    public int getSumElephantMan() {
        return sumElephantMan;
    }
    public void setSumElephantMan(int sumElephantMan) {
        this.sumElephantMan = sumElephantMan;
    }
}
