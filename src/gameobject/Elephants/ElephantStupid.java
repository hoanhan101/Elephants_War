package gameobject.Elephants;

/**
 * Created by HP on 7/14/2016.
 */
public class ElephantStupid extends Elephant {

    public static final String STUPID = "Resource/Char101/Stupid 15/Stupid 1.png";
    private static final int TYPE_6 = 6;
    private static final int TYPE_16 = 16;
    public static final int STRENGTH_ELEPHANT_6 = 200;
    public ElephantStupid(int posY,int posX, int type, int speed) {
        super(posY,posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_6:
                loadAnimation(6,STUPID,STRENGTH_ELEPHANT_6);
                break;
            case TYPE_16:
                loadAnimation(16,STUPID,STRENGTH_ELEPHANT_6);
                break;
        }
    }
}
