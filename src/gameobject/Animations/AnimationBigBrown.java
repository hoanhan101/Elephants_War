package gameobject.Animations;

/**
 * Created by hoanhan on 7/15/16.
 */
public class AnimationBigBrown extends Animation {
    public  static final String BIG_BROWN_GIRL = "Resource/Char101/BigBrown 21/BigBrown " ;
    public  static final String BIG_BROWN_OLD = "Resource/Char101/BigBrown 21/BigBrown " ;
    public  static final String BIG_BROWN_PUSH_GIRL = "Resource/Char101/BigBrownPush 30/BigBrownPush " ;
    public  static final String BIG_BROWN_PUSH_OLD = "Resource/Char101/BigBrownPush 30/BigBrownPush " ;
    public  static final String PNG = ".png";

    public AnimationBigBrown(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 21; i++){
            if(type == 7) {
                getAnimation(BIG_BROWN_GIRL,PNG,i+1,7);
            }
            if(type == 17) {
                getAnimation(BIG_BROWN_OLD,PNG,i+1,17);
            }
        }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 30; i++){
            if (type == 7) {
                getAnimation(BIG_BROWN_PUSH_GIRL,PNG, i + 1, 7);
            }
            if (type == 17) {
                getAnimation(BIG_BROWN_PUSH_OLD,PNG, i + 1, 17);
            }

        }
    }
}
