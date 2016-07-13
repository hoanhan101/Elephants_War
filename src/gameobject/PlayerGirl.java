package gameobject;

import interf.CallElephant;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerGirl extends Player {

    Random random = new Random();

    public PlayerGirl(int posX, int type) {
        super(posX, type);
    }

    @Override
    public void call() {
        int x = random.nextInt(2);
        listElephant.add(new Elephant(0,x,1));
    }
}
