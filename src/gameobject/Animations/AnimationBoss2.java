package gameobject.Animations;

/**
 * Created by hoanhan on 7/15/16.
 */
public class AnimationBoss2 extends Animation {
    public  static final String BOSS2_GIRL = "Resource/Char101/Boss2 26/Boss2 " ;
    public  static final String BOSS2_OLD = "Resource/Char101/Boss2 26/Boss2 " ;
    public  static final String BOSS2_PUSH_GIRL = "Resource/Char101/Boss2Push 37/Boss2Push " ;
    public  static final String BOSS2_PUSH_OLD = "Resource/Char101/Boss2Push 37/Boss2Push " ;
    public  static final String PNG = ".png";

    public AnimationBoss2(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 26; i++){
            if(type == 4) {
                getAnimation(BOSS2_GIRL,PNG,i+1,4);
            }
            if(type == 14) {
                getAnimation(BOSS2_OLD,PNG,i+1,14);
            }
        }
    }

    public void doPushAnimation(int type){
        frames.clear();
        for(int i = 0; i < 37; i++){
            if (type == 4) {
                getAnimation(BOSS2_PUSH_GIRL,PNG, i + 1, 4);
            }
            if (type == 14) {
                getAnimation(BOSS2_PUSH_OLD,PNG, i + 1, 14);
            }

        }
    }
}
