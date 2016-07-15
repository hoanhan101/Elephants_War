package gameobject;

import interf.CallElephant;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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
        int x = random.nextInt(3);
        if(x == 0)
            listElephant.add(new ElephantBlue(0,1,SPEED_GTRL));
        if(x == 1)
            listElephant.add(new ElephantAngry(0,2,SPEED_GTRL));
        if(x == 2)
            listElephant.add(new ElephantBoss1(0,3,SPEED_GTRL));
    }
}
