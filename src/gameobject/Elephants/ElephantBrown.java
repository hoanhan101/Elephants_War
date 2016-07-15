package gameobject.Elephants;

/**
 * Created by HP on 7/14/2016.
 */
public class ElephantBrown extends Elephant {

    public static final String BROWN = "Resource/Char101/Brown 26/Brown 1.png";
    private static final int TYPE_5 = 5;
    private static final int TYPE_15 = 15;
    public static final int STRENGTH_ELEPHANT_5 = 600;
    public ElephantBrown(int posX, int type, int speed) {
        super(posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_5:
                loadAnimation(5,BROWN,STRENGTH_ELEPHANT_5);
                break;
            case TYPE_15:
                loadAnimation(15,BROWN,STRENGTH_ELEPHANT_5);
                break;
        }
    }
}
