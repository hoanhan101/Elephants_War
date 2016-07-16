package gameobject.Players;

import gameobject.Elephants.Elephant;

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

    private BufferedImage sprite;
    private int posX;
    private int posY;
    private static int[] sumElephantGirl = new int[5] ;
    private static int[] sumElephantMan = new int[5];

    public ArrayList<Elephant> listElephant1 = new ArrayList<Elephant>();
    public ArrayList<Elephant> listElephant2 = new ArrayList<Elephant>();
    public ArrayList<Elephant> listElephant3 = new ArrayList<Elephant>();
    public ArrayList<Elephant> listElephant4 = new ArrayList<Elephant>();
    public ArrayList<Elephant> listElephant5 = new ArrayList<Elephant>();

    public Player(int posX,int posY, int type){
        this.posX = posX;
        this.posY = posY;
        loadSpriteByType(type);
    }


    public void loadSpriteByType(int type) {

    }

    public void call(){
    }

    public void draw(Graphics g){

        g.drawImage(sprite,posX, posY,null);
        draw_elephant(g,listElephant1);
        draw_elephant(g,listElephant2);
        draw_elephant(g,listElephant3);
        draw_elephant(g,listElephant4);
        draw_elephant(g,listElephant5);
    }
    public void draw_elephant(Graphics g,ArrayList<Elephant> list){
        int n = list.size();
        if(list.size() > 0)
        for(int i = 0; i< n; i++){
            list.get(i).draw(g);
        }
    }
    public void update (int x){
        update_elephant(listElephant1,x);
        update_elephant(listElephant2,x);
        update_elephant(listElephant3,x);
        update_elephant(listElephant4,x);
        update_elephant(listElephant5,x);
    }
    public void update_elephant(ArrayList<Elephant> list,int x){
        Iterator<Elephant> cursorElephant = list.iterator();
        try {
            while (cursorElephant.hasNext()) {
                Elephant elephant = cursorElephant.next();
                elephant.update();
                if (elephant.getPosX() > 1000) {
                    changeSumPlayer(x, elephant);
                    cursorElephant.remove();
                }
                if (elephant.getPosX() <  0) {
                    changeSumPlayer(x, elephant);
                    cursorElephant.remove();
                }

            }
        }catch (Exception e){
        }
    }
    private void changeSumPlayer(int x,Elephant elephant){
        if(x == 1) {
//            if(elephant.posY == 200)
//                sumElephantGirl[0] -= elephant.getStrength();
//            if(elephant.posY == 300)
//                sumElephantGirl[1] -= elephant.getStrength();
//            if(elephant.posY == 400)
//                sumElephantGirl[2] -= elephant.getStrength();
//            if(elephant.posY == 500)
//                sumElephantGirl[3] -= elephant.getStrength();
//            if(elephant.posY == 600)
//                sumElephantGirl[4] -= elephant.getStrength();
            changeSumPlayer_elephant(sumElephantGirl[0],200,elephant);
            changeSumPlayer_elephant(sumElephantGirl[1],300,elephant);
            changeSumPlayer_elephant(sumElephantGirl[2],400,elephant);
            changeSumPlayer_elephant(sumElephantGirl[3],500,elephant);
            changeSumPlayer_elephant(sumElephantGirl[4],600,elephant);
            for(int i = 0; i < 5; i++)
                if (sumElephantGirl[i] < 0) sumElephantGirl[i]= 0;
        }
        if(x == 2) {
//            if(elephant.posY == 200)
//                sumElephantMan[0] -= elephant.getStrength();
//            if(elephant.posY == 300)
//                sumElephantMan[1] -= elephant.getStrength();
//            if(elephant.posY == 400)
//                sumElephantMan[2] -= elephant.getStrength();
//            if(elephant.posY == 500)
//                sumElephantMan[3] -= elephant.getStrength();
//            if(elephant.posY == 600)
//                sumElephantMan[4] -= elephant.getStrength();
            changeSumPlayer_elephant(sumElephantMan[0],200,elephant);
            changeSumPlayer_elephant(sumElephantMan[1],300,elephant);
            changeSumPlayer_elephant(sumElephantMan[2],400,elephant);
            changeSumPlayer_elephant(sumElephantMan[3],500,elephant);
            changeSumPlayer_elephant(sumElephantMan[4],600,elephant);
            for(int i = 0; i < 5; i++)
            if (sumElephantMan[i] < 0) sumElephantMan[i] = 0;
        }
    }
    public void changeSumPlayer_elephant(int x,int y,Elephant elephant){
        if(elephant.posY == y) x -= elephant.getStrength();
    }
    public void checkCollision(Player player){
//        for(int i = 0 ; i < listElephant.size() ; i++) {
//            for (int j = 0; j < player.listElephant.size() ; j++) {
//                    if (listElephant.get(i).animation.getRectangle().intersects(player.listElephant.get(j).animation.getRectangle())) {
//                        if (listElephant.get(i).hasCollision == false)
//                            sumElephantGirl += listElephant.get(i).getStrength();
//                        if (player.listElephant.get(j).hasCollision == false)
//                            sumElephantMan += player.listElephant.get(j).getStrength();
//
//                        listElephant.get(i).hasCollision = true;
//                        player.listElephant.get(j).hasCollision = true;
//
//                        if (sumElephantGirl < sumElephantMan) {
//                            changeSpeedCollision(SPEED_UPDATE_GIRL,player);
//                        }
//                        if (sumElephantMan < sumElephantGirl) {
//                            changeSpeedCollision(SPEED_UPDATE_OLDMAN,player);
//                        }
//                        if (sumElephantMan == sumElephantGirl) {
//                            changeSpeedCollision(0,player);
//                        }
//                    }
//            }
//        }
        checkCollision_elephant(listElephant1,player.listElephant1,sumElephantGirl[0],sumElephantMan[0],player);
        checkCollision_elephant(listElephant2,player.listElephant2,sumElephantGirl[1],sumElephantMan[1],player);
        checkCollision_elephant(listElephant3,player.listElephant3,sumElephantGirl[2],sumElephantMan[2],player);
        checkCollision_elephant(listElephant4,player.listElephant4,sumElephantGirl[3],sumElephantMan[3],player);
        checkCollision_elephant(listElephant5,player.listElephant5,sumElephantGirl[4],sumElephantMan[4],player);
    }
    public void checkCollision_elephant(ArrayList<Elephant> list,ArrayList<Elephant> list2,int x,int y,Player player){
        int a = list.size();
        int b = list2.size();
        for(int i = 0; i < a; i++)
            for(int j = 0 ; j < b; j++){
                if (list.get(i).animation.getRectangle().intersects(list2.get(j).animation.getRectangle())){
                    if (list.get(i).hasCollision == false)
                        x += list.get(i).getStrength();
                    if(list2.get(i).hasCollision == false)
                        y += list2.get(i).getStrength();
                    list.get(i).hasCollision = true;
                    list2.get(i).hasCollision = true;
                    if(x < y) changeSpeedCollision(SPEED_UPDATE_GIRL,list,list2);
                    if(x > y) changeSpeedCollision(SPEED_UPDATE_OLDMAN,list,list2);
                    if(x == y) changeSpeedCollision(0,list,list2);
                }
            }

    }
    private void changeSpeedCollision(int x,ArrayList<Elephant> list, ArrayList<Elephant> list2){
        for(int k = 0; k < list.size(); k++)
            if(list.get(k).hasCollision) list.get(k).setSpeed(x);
        for(int k = 0; k < list2.size(); k++)
            if(list2.get(k).hasCollision) list2.get(k).setSpeed(x);
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
