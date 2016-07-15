package gameobject.Elephants;

/**
 * Created by HP on 7/14/2016.
 */
public class ElephantBoss2 extends Elephant {

    public static final String BOSS_2 = "Resource/Char101/Boss2 26/Boss2 1.png";
    private static final int TYPE_4 = 4;
    private static final int TYPE_14 = 14;
    public static final int STRENGTH_ELEPHANT_4 = 1000;
    public ElephantBoss2(int posX, int type, int speed) {
        super(posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_4:
                loadAnimation(4,BOSS_2,STRENGTH_ELEPHANT_4);
                break;
            case TYPE_14:
                loadAnimation(14,BOSS_2,STRENGTH_ELEPHANT_4);
                break;
        }
    }
}
