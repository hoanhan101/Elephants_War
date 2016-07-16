package gameobject.Players;

import gameobject.Elephants.Elephant;
import gameobject.Singleton.ManagerGirl;
import gameobject.Singleton.ManagerScore;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Player {

    private static final int SPEED_UPDATE_GIRL = -1;
    private static final int SPEED_UPDATE_OLDMAN = 1;

    public BufferedImage sprite;
    public int posX;
    public int posY;
    private static int[] sumElephantGirl = new int[5] ;
    private static int[] sumElephantMan = new int[5];

    public ArrayList<Elephant> listElephant = new ArrayList<Elephant>();

    public Player(int posX,int posY, int type){
        this.posX = posX;
        this.posY = posY;
        loadSpriteByType(type);
    }


    public void loadSpriteByType(int type) {

    }

    public void call(int x){
    }

    public void draw(Graphics g){
                g.drawImage(sprite,posX, posY,null);
            for (int i = 0; i < listElephant.size(); i++){
                listElephant.get(i).draw(g);
            }

    }
    public void update (int x){
        Iterator<Elephant> cursorElephant = listElephant.iterator();
        try {
            while (cursorElephant.hasNext()) {
                Elephant elephant = cursorElephant.next();
                elephant.update();
                if (elephant.getPosX() > 1000) {
                    changeSumPlayer(x, elephant);
                    cursorElephant.remove();
                    int n =ManagerScore.getScore1();
                    if(x == 1) ManagerScore.getInstance().setScore1(n+1);
                    if(x == 2) ManagerScore.getInstance().setScore1(n+1);
                }
                if (elephant.getPosX() < 0) {
                    changeSumPlayer(x, elephant);
                    cursorElephant.remove();
                    int n =ManagerScore.getScore2();
                    if(x == 2) ManagerScore.getInstance().setScore2(n+1);
                    if(x == 1) ManagerScore.getInstance().setScore2(n+1);
                }

            }
        }catch (Exception e){
        }
    }
    private void changeSumPlayer(int x,Elephant elephant){
        if(x == 1) {
            if(elephant.posY + elephant.sprite.getHeight() == 200)
                sumElephantGirl[0] -= elephant.getStrength();
            if(elephant.posY + elephant.sprite.getHeight() == 300)
                sumElephantGirl[1] -= elephant.getStrength();
            if(elephant.posY + elephant.sprite.getHeight()== 400)
                sumElephantGirl[2] -= elephant.getStrength();
            if(elephant.posY+ elephant.sprite.getHeight() == 500)
                sumElephantGirl[3] -= elephant.getStrength();
            if(elephant.posY + elephant.sprite.getHeight()== 600)
                sumElephantGirl[4] -= elephant.getStrength();
            for(int i = 0; i < 5; i++)
                if (sumElephantGirl[i] < 0) sumElephantGirl[i]= 0;
        }
        if(x == 2) {
            if(elephant.posY+ elephant.sprite.getHeight() == 200)
                sumElephantMan[0] -= elephant.getStrength();
            if(elephant.posY+ elephant.sprite.getHeight() == 300)
                sumElephantMan[1] -= elephant.getStrength();
            if(elephant.posY+ elephant.sprite.getHeight() == 400)
                sumElephantMan[2] -= elephant.getStrength();
            if(elephant.posY + elephant.sprite.getHeight()== 500)
                sumElephantMan[3] -= elephant.getStrength();
            if(elephant.posY+ elephant.sprite.getHeight() == 600)
                sumElephantMan[4] -= elephant.getStrength();
            for(int i = 0; i < 5; i++)
            if (sumElephantMan[i] < 0) sumElephantMan[i] = 0;
        }
    }
    public void checkCollision(Player player){
        for(int i = 0 ; i < listElephant.size() ; i++) {
            for (int j = 0; j < player.listElephant.size() ; j++) {
                    if (listElephant.get(i).animation.getRectangle().intersects(player.listElephant.get(j).animation.getRectangle() )&& ((listElephant.get(i).posY+listElephant.get(i).getSprite().getHeight()) == (player.listElephant.get(j).posY+player.listElephant.get(j).getSprite().getHeight()))) {
                        if (listElephant.get(i).hasCollision == false) {

                            if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 200) {
                                sumElephantGirl[0] += listElephant.get(i).getStrength();

                            }
                            if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 300)
                                sumElephantGirl[1] += listElephant.get(i).getStrength();
                            if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 400)
                                sumElephantGirl[2] += listElephant.get(i).getStrength();
                            if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 500)
                                sumElephantGirl[3] += listElephant.get(i).getStrength();
                            if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 600)
                                sumElephantGirl[4] += listElephant.get(i).getStrength();
                        }
                        if (player.listElephant.get(j).hasCollision == false) {
                            if(player.listElephant.get(j).posY +player.listElephant.get(j).getSprite().getHeight() == 200)
                                sumElephantMan[0] += player.listElephant.get(j).getStrength();
                            if(player.listElephant.get(j).posY +player.listElephant.get(j).getSprite().getHeight() == 300)
                                sumElephantMan[1] += player.listElephant.get(j).getStrength();
                            if(player.listElephant.get(j).posY +player.listElephant.get(j).getSprite().getHeight() == 400)
                                sumElephantMan[2] += player.listElephant.get(j).getStrength();
                            if(player.listElephant.get(j).posY +player.listElephant.get(j).getSprite().getHeight()== 500)
                                sumElephantMan[3] += player.listElephant.get(j).getStrength();
                            if(player.listElephant.get(j).posY +player.listElephant.get(j).getSprite().getHeight() == 600)
                                sumElephantMan[4] += player.listElephant.get(j).getStrength();

                        }

                        listElephant.get(i).hasCollision = true;
                        player.listElephant.get(j).hasCollision = true;
                        for(int k = 0; k < 5 ;k++) {
                            if (sumElephantGirl[k] < sumElephantMan[k]) {
                                if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 200 && k == 0 )
                                    changeSpeedCollision(k,SPEED_UPDATE_GIRL, player);
                                if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 300 && k == 1 )
                                    changeSpeedCollision(k,SPEED_UPDATE_GIRL, player);
                                if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 400 && k == 2 )
                                    changeSpeedCollision(k,SPEED_UPDATE_GIRL, player);
                                if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 500 && k == 3 )
                                    changeSpeedCollision(k,SPEED_UPDATE_GIRL, player);
                                if(listElephant.get(i).posY + listElephant.get(i).getSprite().getHeight() == 600 && k == 4 )
                                    changeSpeedCollision(k,SPEED_UPDATE_GIRL, player);

                            }
                            if (sumElephantMan[k] < sumElephantGirl[k]) {
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 200 && k == 0 )
                                    changeSpeedCollision(k,SPEED_UPDATE_OLDMAN, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 300 && k == 1 )
                                    changeSpeedCollision(k,SPEED_UPDATE_OLDMAN, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 400 && k == 2 )
                                    changeSpeedCollision(k,SPEED_UPDATE_OLDMAN, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 500 && k == 3 )
                                    changeSpeedCollision(k,SPEED_UPDATE_OLDMAN, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 600 && k == 4 ) {
                                    changeSpeedCollision(k, SPEED_UPDATE_OLDMAN, player);
                                }
                            }
                            if (sumElephantMan[k] == sumElephantGirl[k]) {
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 200 && k == 0 )
                                    changeSpeedCollision(k,0, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 300 && k == 1 )
                                    changeSpeedCollision(k,0, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 400 && k == 2 )
                                    changeSpeedCollision(k,0, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 500 && k == 3 )
                                    changeSpeedCollision(k,0, player);
                                if(player.listElephant.get(j).posY + player.listElephant.get(j).getSprite().getHeight() == 600 && k == 4 ){
                                    changeSpeedCollision(k,0, player);

                                }

                            }
                        }
                    }
            }
        }
    }

    private void changeSpeedCollision(int n,int x,Player player){
        for(int k = 0; k < listElephant.size(); k++) {
            if (listElephant.get(k).hasCollision){
                if(n==0 && (listElephant.get(k).posY + listElephant.get(k).getSprite().getHeight()) == 200 )
                listElephant.get(k).setSpeed(x);
                if(n==1 && (listElephant.get(k).posY + listElephant.get(k).getSprite().getHeight()) == 300 )
                    listElephant.get(k).setSpeed(x);
                if(n==2 && (listElephant.get(k).posY + listElephant.get(k).getSprite().getHeight()) == 400 )
                    listElephant.get(k).setSpeed(x);
                if(n==3 && (listElephant.get(k).posY + listElephant.get(k).getSprite().getHeight()) == 500 )
                    listElephant.get(k).setSpeed(x);
                if(n==4 && (listElephant.get(k).posY + listElephant.get(k).getSprite().getHeight()) == 600 ) {
                    listElephant.get(k).setSpeed(x);
                }
            }
        }
        for(int k = 0; k < player.listElephant.size(); k++)
            if(player.listElephant.get(k).hasCollision) {
                if(n==0 && (player.listElephant.get(k).posY + player.listElephant.get(k).getSprite().getHeight()) == 200 )
                    player.listElephant.get(k).setSpeed(x);
                if(n==1 && (player.listElephant.get(k).posY + player.listElephant.get(k).getSprite().getHeight()) == 300 )
                    player.listElephant.get(k).setSpeed(x);
                if(n==2 && (player.listElephant.get(k).posY + player.listElephant.get(k).getSprite().getHeight()) == 400 )
                    player.listElephant.get(k).setSpeed(x);
                if(n==3 &&( player.listElephant.get(k).posY + player.listElephant.get(k).getSprite().getHeight()) == 500 )
                    player.listElephant.get(k).setSpeed(x);
                if(n==4 && (player.listElephant.get(k).posY + player.listElephant.get(k).getSprite().getHeight()) == 600 )
                    player.listElephant.get(k).setSpeed(x);
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
