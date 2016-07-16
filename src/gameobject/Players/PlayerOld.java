package gameobject.Players;

import gameobject.Elephants.*;
import gameobject.Menu.ManagerWay;
import gameobject.Menu.ManagerWay2;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerOld extends Player {
    public static final int TYPE_PLAYER_OLD = 2;

    public static final String PLAYER_OLDMAN = "Resource/Char/2OldMan.png";


    final int SPEED_MAN = -1;

    Random random = new Random();

    public PlayerOld(int posX, int posY, int type) {
        super(posX,posY, type);
    }

    public void loadSpriteByType(int type) {
        switch (type) {
            case TYPE_PLAYER_OLD :
                try {
                    setSprite(ImageIO.read(new File(PLAYER_OLDMAN)));
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
            addElephant().add(new ElephantBlue(ManagerWay2.getInstance().getWay() - 48,900,11,SPEED_MAN));
        if(x == 1)
            addElephant().add(new ElephantAngry(ManagerWay2.getInstance().getWay() - 101,900,12,SPEED_MAN));
        if(x == 2)
            addElephant().add(new ElephantBoss1(ManagerWay2.getInstance().getWay() - 190,900,13,SPEED_MAN));
        if(x == 3)
            addElephant().add(new ElephantBoss2(ManagerWay2.getInstance().getWay() - 220,900,14,SPEED_MAN));
        if(x == 4)
            addElephant().add(new ElephantBrown(ManagerWay2.getInstance().getWay() - 55,900,15,SPEED_MAN));
        if(x == 5)
            addElephant().add(new ElephantStupid(ManagerWay2.getInstance().getWay() - 60,900,16,SPEED_MAN));
        if(x == 6)
            addElephant().add(new ElephantBigBrown(ManagerWay2.getInstance().getWay() - 69,900,17,SPEED_MAN));
        if(x == 7)
            addElephant().add(new ElephantGreen(ManagerWay2.getInstance().getWay() - 48,900,18,SPEED_MAN));
        if(x == 8)
            addElephant().add(new ElephantPink(ManagerWay2.getInstance().getWay() - 62,900,19,SPEED_MAN));
    }
    public ArrayList<Elephant> addElephant(){
        if(ManagerWay2.getInstance().getWay() == 200)  return listElephant1;
        if(ManagerWay2.getInstance().getWay() == 300)  return listElephant2;
        if(ManagerWay2.getInstance().getWay() == 400)  return listElephant3;
        if(ManagerWay2.getInstance().getWay() == 500)  return listElephant4;
        if(ManagerWay2.getInstance().getWay() == 600)  return listElephant5;
        return null;
    }
}
