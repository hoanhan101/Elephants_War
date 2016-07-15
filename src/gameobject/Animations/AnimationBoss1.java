package gameobject.Animations;

/**
 * Created by HP on 7/14/2016.
 */
public class AnimationBoss1 extends Animation {
    public  static final String BOSS1_GIRL = "Resource/Char101/Boss1 20/Boss1 " ;
    public  static final String BOSS1_OLD = "Resource/Char101/Boss1 20/Boss1 " ;
    public  static final String BOSS1_PUSH_GIRL = "Resource/Char101/Boss1Push 31/Boss1Push " ;
    public  static final String BOSS1_PUSH_OLD = "Resource/Char101/Boss1Push 31/Boss1Push " ;
    public  static final String PNG = ".png";

    public AnimationBoss1(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 20; i++){
            if(type == 3) {
                getAnimation(BOSS1_GIRL,PNG,i+1,3);
            }
            if(type == 13) {
                getAnimation(BOSS1_OLD,PNG,i+1,13);
            }
        }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 31; i++){
            if (type == 3) {
                getAnimation(BOSS1_PUSH_GIRL,PNG, i + 1, 3);
            }
            if (type == 13) {
                getAnimation(BOSS1_PUSH_OLD,PNG, i + 1, 13);
            }

        }
    }
}
