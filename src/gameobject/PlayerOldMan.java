package gameobject;

import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerOldMan extends Player{

    Random random = new Random();

    public PlayerOldMan(int posX,int posY, int type) {
        super(posX,posY, type);
    }

    @Override
    public void call() {
        int x = random.nextInt(3);
        listElephant.add(new Elephant(900,x+4,-1));
    }
}
