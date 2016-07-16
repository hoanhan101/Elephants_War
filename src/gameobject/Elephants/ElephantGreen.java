package gameobject.Elephants;

/**
 * Created by hoanhan on 7/15/16.
 */
public class ElephantGreen extends Elephant {

    public static final String GREEN = "Resource/Char101/Green 11/Green 1.png";
    private static final int TYPE_8 = 8;
    private static final int TYPE_18 = 18;
    public static final int STRENGTH_ELEPHANT_8 = 500;
    public ElephantGreen(int posY,int posX, int type, int speed) {
        super( posY,posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_8:
                loadAnimation(8,GREEN,STRENGTH_ELEPHANT_8);
                break;
            case TYPE_18:
                loadAnimation(18,GREEN,STRENGTH_ELEPHANT_8);
                break;
        }
    }
}
