package gameobject;

/**
 * Created by HP on 7/14/2016.
 */
public class AnimationBlue extends Animation {
    public  static final String BLUE_GIRL = "Resource/Char/Blue/Blue " ;
    public  static final String BLUE_OLD = "Resource/Char/Blue/Blue " ;
    public  static final String PNG = ".png";

    public AnimationBlue(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 20; i++){
            if(type == 1) {
                getAnimation(BLUE_GIRL,PNG,i+1,1);
            }
            if(type == 11) {
                getAnimation(BLUE_OLD,PNG,i+1,11);
            }
        }
    }
}
