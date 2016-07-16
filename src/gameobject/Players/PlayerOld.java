package gameobject.Players;

import gameobject.Elephants.*;
import gameobject.Singleton.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class PlayerOld extends Player {
    public static final int TYPE_PLAYER_OLD = 2;

    public static final String PLAYER_OLDMAN = "Resource/Char/2OldMan.png";
    public AnimationOld animationOld = new AnimationOld();
    AnimationGirl animationGirl;
    final int SPEED_MAN = -1;
    public int n;
    Random random = new Random();

    public PlayerOld(int posX, int posY, int type) {
        super(posX,posY, type);
        animationOld = new AnimationOld(11,31);
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

    public void draw(Graphics g){

        n = ManagerOld.getInstance().getAnimationOld();
        if(n!=2)
            g.drawImage(sprite,posX, posY,null);
        for (int i = 0; i < listElephant.size(); i++){
            listElephant.get(i).draw(g);
        }
    }

    @Override
    public void call() {
        int x = random.nextInt(9);
        if(x == 1) x -= 1;
        if(x == 2) x += 2;
        if(x == 3) x += 3;
        boolean a = ManagerBoss1.getInstance().isHas_eat();
        boolean b = ManagerBoss1.getInstance().isOld_eat();
        boolean c =ManagerAngry.getInstance().isHas_eat();
        boolean d = ManagerAngry.getInstance().isOld_eat();
        boolean e = ManagerBoss2.getInstance().isHas_eat();
        boolean f = ManagerBoss2.getInstance().isOld_eat();
        if( c && d ) {
            x = 1;
            ManagerAngry.getInstance().setHas_eat(false);
            ManagerAngry.getInstance().setOld_eat(false);

        }
        if(a && b){
            ManagerBoss1.getInstance().setHas_eat(false);
            ManagerBoss1.getInstance().setOld_eat(false);
            x = 2;
        }
        if(e && f) {
            x = 3;
            ManagerBoss2.getInstance().setHas_eat(false);
            ManagerBoss2.getInstance().setOld_eat(false);
        }
        if(x == 0)
            listElephant.add(new ElephantBlue(ManagerWay2.getInstance().getWay() - 48,900,11,SPEED_MAN));
        if(x == 1)
            listElephant.add(new ElephantAngry(ManagerWay2.getInstance().getWay() - 101,900,12,SPEED_MAN));
        if(x == 2)
            listElephant.add(new ElephantBoss1(ManagerWay2.getInstance().getWay() - 190,900,13,SPEED_MAN));
        if(x == 3)
            listElephant.add(new ElephantBoss2(ManagerWay2.getInstance().getWay() - 220,900,14,SPEED_MAN));
        if(x == 4)
            listElephant.add(new ElephantBrown(ManagerWay2.getInstance().getWay() - 55,900,15,SPEED_MAN));
        if(x == 5)
            listElephant.add(new ElephantStupid(ManagerWay2.getInstance().getWay() - 60,900,16,SPEED_MAN));
        if(x == 6)
            listElephant.add(new ElephantBigBrown(ManagerWay2.getInstance().getWay() - 69,900,17,SPEED_MAN));
        if(x == 7)
            listElephant.add(new ElephantGreen(ManagerWay2.getInstance().getWay() - 48,900,18,SPEED_MAN));
        if(x == 8)
            listElephant.add(new ElephantPink(ManagerWay2.getInstance().getWay() - 62,900,19,SPEED_MAN));
    }
}
