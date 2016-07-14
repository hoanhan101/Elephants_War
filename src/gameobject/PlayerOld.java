package gameobject;

import interf.CallElephant;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerOld extends Player {

    final int SPEED_MAN = -1;

    Random random = new Random();

    public PlayerOld(int posX, int posY, int type) {
        super(posX,posY, type);
    }

    @Override
    public void call() {
        int x = random.nextInt(3);
        if(x == 0)
            listElephant.add(new ElephantBlue(900,11,SPEED_MAN));
        if(x == 1)
            listElephant.add(new ElephantAngry(900,12,SPEED_MAN));
        if(x == 2)
            listElephant.add(new ElephantBoss1(900,13,SPEED_MAN));
    }
}
