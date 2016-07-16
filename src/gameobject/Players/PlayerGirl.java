package gameobject.Players;

import gameobject.Elephants.*;
import gameobject.Menu.ManagerWay;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerGirl extends Player {
    public static final String PLAYER_GIRL = "Resource/Char/1Girl.png";
    public static final int TYPE_PLAYER_GIRL = 1;

    final int SPEED_GTRL = 1;

    Random random = new Random();

    public PlayerGirl(int posX,int posY, int type) {
        super(posX,posY,type);
    }

    public void loadSpriteByType(int type) {
        switch (type) {
            case TYPE_PLAYER_GIRL:
                try {
                    setSprite(ImageIO.read(new File(PLAYER_GIRL)));

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void call() {
        int x = random.nextInt(9);
        if(x == 0)
            addElephant().add(new ElephantBlue(ManagerWay.getInstance().getWay() - 48,0,1,SPEED_GTRL));
        if(x == 1)
            addElephant().add(new ElephantAngry(ManagerWay.getInstance().getWay() - 101,0,2,SPEED_GTRL));
        if(x == 2)
            addElephant().add(new ElephantBoss1(ManagerWay.getInstance().getWay() - 190,0,3,SPEED_GTRL));
        if(x == 3)
            addElephant().add(new ElephantBoss2(ManagerWay.getInstance().getWay() - 220,0,4,SPEED_GTRL));
        if(x == 4)
            addElephant().add(new ElephantBrown(ManagerWay.getInstance().getWay() - 55,0,5,SPEED_GTRL));
        if(x == 5)
            addElephant().add(new ElephantStupid(ManagerWay.getInstance().getWay() - 60,0,6,SPEED_GTRL));
        if(x == 6)
            addElephant().add(new ElephantBigBrown(ManagerWay.getInstance().getWay() - 69,0,7,SPEED_GTRL));
        if(x == 7)
            addElephant().add(new ElephantGreen(ManagerWay.getInstance().getWay() - 48,0,8,SPEED_GTRL));
        if(x == 8)
            addElephant().add(new ElephantPink(ManagerWay.getInstance().getWay() - 62,0,9,SPEED_GTRL));
    }

    public ArrayList<Elephant> addElephant(){
        if(ManagerWay.getInstance().getWay() == 200)  return listElephant1;
        if(ManagerWay.getInstance().getWay() == 300)  return listElephant2;
        if(ManagerWay.getInstance().getWay() == 400)  return listElephant3;
        if(ManagerWay.getInstance().getWay() == 500)  return listElephant4;
        if(ManagerWay.getInstance().getWay() == 600)  return listElephant5;
        return null;
    }
}
