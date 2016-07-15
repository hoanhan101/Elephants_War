package gameobject.Elephants;

/**
 * Created by hoanhan on 7/13/16.
 */
public class ElephantBoss1 extends Elephant {

    private static final int TYPE_3 = 3;
    private static final int TYPE_13 = 13;
    private static final String BOSS_1 = "Resource/Char/1Boss.png";
    public static final int STRENGTH_ELEPHANT_3 = 300;
    public ElephantBoss1(int posX, int type, int speed) {
        super(posX, type, speed);
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
