package gameobject.Elephants;

/**
 * Created by hoanhan on 7/15/16.
 */
public class ElephantPink extends Elephant {

    public static final String PINK = "Resource/Char101/Pink 20/Pink 1.png";
    private static final int TYPE_9 = 9;
    private static final int TYPE_19 = 19;
    public static final int STRENGTH_ELEPHANT_9 = 300;
    public ElephantPink(int posX, int type, int speed) {
        super(posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_9:
                loadAnimation(9,PINK,STRENGTH_ELEPHANT_9);
                break;
            case TYPE_19:
                loadAnimation(19,PINK,STRENGTH_ELEPHANT_9);
                break;
        }
    }
}
