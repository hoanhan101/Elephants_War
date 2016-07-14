package gameobject;

import interf.CallElephant;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerGirl extends Player implements CallElephant{
    final int SPEED_GTRL = 1;

    Random random = new Random();

    public PlayerGirl(int posX,int posY, int type) {
        super(posX,posY,type);
    }

    @Override
    public void call() {
        int x = random.nextInt(3);
        listElephant.add(new Elephant(0,x+1,SPEED_GTRL));
    }


}
