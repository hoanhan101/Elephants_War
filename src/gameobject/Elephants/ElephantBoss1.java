package gameobject.Elephants;

/**
 * Created by hoanhan on 7/13/16.
 */
public class ElephantBoss1 extends Elephant {
    public static final String BOSS_1 = "Resource/Char101/Boss1 20/Boss1 1.png";
    private static final int TYPE_3 = 3;
    private static final int TYPE_13 = 13;
    public static final int STRENGTH_ELEPHANT_3 = 1100;
    public ElephantBoss1(int posY,int posX, int type, int speed) {
        super(posY,posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_3:
                loadAnimation(3,BOSS_1,STRENGTH_ELEPHANT_3);
                break;
            case TYPE_13:
                loadAnimation(13,BOSS_1,STRENGTH_ELEPHANT_3);
                break;
        }
    }
}
