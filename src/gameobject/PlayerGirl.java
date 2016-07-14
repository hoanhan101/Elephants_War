package gameobject;

import interf.CallElephant;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerGirl extends Player {
    final int SPEED_GTRL = 1;

    Random random = new Random();

    public PlayerGirl(int posX,int posY, int type) {
        super(posX,posY,type);
    }

    @Override
    public void call() {
        int x = random.nextInt(3);
        if(x == 0)
            listElephant.add(new ElephantBlue(0,1,SPEED_GTRL));
        if(x == 1)
            listElephant.add(new ElephantAngry(0,2,SPEED_GTRL));
        if(x == 2)
            listElephant.add(new ElephantBoss1(0,3,SPEED_GTRL));
    }


}
