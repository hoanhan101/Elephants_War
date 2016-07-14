package gameobject;

import interf.CallElephant;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerOldMan extends Player implements CallElephant{

    final int SPEED_OLDMAN = -1;

    Random random = new Random();

    public PlayerOldMan(int posX,int posY, int type) {
        super(posX,posY, type);
    }

    @Override
    public void call() {
        int x = random.nextInt(3);
        listElephant.add(new Elephant(900,x+4,SPEED_OLDMAN));
    }
}
