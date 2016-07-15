package gameobject.Elephants;

/**
 * Created by hoanhan on 7/13/16.
 */
public class ElephantBlue extends Elephant {

    public static final String BLUE = "Resource/Char101/Blue 20/Blue 1.png";
    private static final int TYPE_1 = 1;
    private static final int TYPE_11 = 11;
    public static final int STRENGTH_ELEPHANT_1 = 400;

    public ElephantBlue(int posX, int type, int speed) {
        super(posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_1:
                loadAnimation(1,BLUE,STRENGTH_ELEPHANT_1);
                break;
            case TYPE_11:
                loadAnimation(11,BLUE,STRENGTH_ELEPHANT_1);
                break;
        }
    }
}
