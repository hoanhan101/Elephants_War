package gameobject.Animations;

/**
 * Created by HP on 7/14/2016.
 */
public class AnimationAngry extends Animation {
    public  static final String ANGRY_GIRL = "Resource/Char101/Angry 10/Angry " ;
    public  static final String ANGRY_OLD = "Resource/Char101/Angry 10/Angry " ;
    public  static final String PNG = ".png";

    public AnimationAngry(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 10; i++){
            if(type == 2) {
                getAnimation(ANGRY_GIRL,PNG,i+1,2);
            }
            if(type == 12) {
                getAnimation(ANGRY_OLD,PNG,i+1,12);
            }
        }
    }
}
