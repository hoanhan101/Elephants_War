package gameobject.Elephants;

/**
 * Created by hoanhan on 7/13/16.
 */
public class ElephantAngry extends Elephant {

    public static final String ANGRY = "Resource/Char101/Angry 10/Angry 1.png";
    public static final int TYPE_2 = 2;
    public static final int TYPE_12 = 12;
    public static final int STRENGTH_ELEPHANT_2 = 800;

    public ElephantAngry(int posY,int posX, int type, int speed) {
        super(posY,posX, type, speed);
    }

    @Override
    protected void loadSpriteByType(int type) {
        switch (type){
            case TYPE_2:
                loadAnimation(2,ANGRY,STRENGTH_ELEPHANT_2);
                break;
            case TYPE_12:
                loadAnimation(12,ANGRY,STRENGTH_ELEPHANT_2);
                break;
        }
    }
}
