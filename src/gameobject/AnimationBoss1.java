package gameobject;

/**
 * Created by HP on 7/14/2016.
 */
public class AnimationBoss1 extends Animation {
    public  static final String BOSS_GIRL = "Resource/Char/Boss/Boss " ;
    public  static final String BOSS_OLD = "Resource/Char/Boss/Boss " ;
    public  static final String PNG = ".png";

    public AnimationBoss1(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 20; i++){
            if(type == 3) {
                getAnimation(BOSS_GIRL,PNG,i+1,3);
            }
            if(type == 13) {
                getAnimation(BOSS_OLD,PNG,i+1,13);
            }
        }
    }
}
