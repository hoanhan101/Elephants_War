package gameobject.Elephants;

/**
 * Created by hoanhan on 7/15/16.
 */
public class ElephantBigBrown extends Elephant {

    public static final String BIG_BROWN = "Resource/Char101/BigBrown 21/BigBrown 1.png";
    public static final int TYPE_7 = 7;
    public static final int TYPE_17 = 17;
    public static final int STRENGTH_ELEPHANT_7 = 700;

    public ElephantBigBrown(int posY,int posX, int type, int speed) {
        super(posY,posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_7:
                loadAnimation(7,BIG_BROWN,STRENGTH_ELEPHANT_7);
                break;
            case TYPE_17:
                loadAnimation(17,BIG_BROWN,STRENGTH_ELEPHANT_7);
                break;
        }
    }
}
