package gameobject.Players;

import gameobject.Elephants.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
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
            listElephant.add(new ElephantBlue(900,11,SPEED_MAN));
        if(x == 1)
            listElephant.add(new ElephantAngry(900,12,SPEED_MAN));
        if(x == 2)
            listElephant.add(new ElephantBoss1(900,13,SPEED_MAN));
        if(x == 3)
            listElephant.add(new ElephantBoss2(900,14,SPEED_MAN));
        if(x == 4)
            listElephant.add(new ElephantBrown(900,15,SPEED_MAN));
        if(x == 5)
            listElephant.add(new ElephantStupid(900,16,SPEED_MAN));
        if(x == 6)
            listElephant.add(new ElephantBigBrown(900,17,SPEED_MAN));
        if(x == 7)
            listElephant.add(new ElephantGreen(900,18,SPEED_MAN));
        if(x == 8)
            listElephant.add(new ElephantPink(900,19,SPEED_MAN));
    }
}
