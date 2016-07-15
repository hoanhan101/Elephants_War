package gameobject.Animations;

/**
 * Created by hoanhan on 7/15/16.
 */
public class AnimationPink extends Animation {
    public  static final String PINK_GIRL = "Resource/Char101/Pink 20/Pink " ;
    public  static final String PINK_OLD = "Resource/Char101/Pink 20/Pink " ;
    public  static final String PINK_PUSH_GIRL = "Resource/Char101/PinkPush 31/PinkPush " ;
    public  static final String PINK_PUSH_OLD = "Resource/Char101/PinkPush 31/PinkPush " ;
    public  static final String PNG = ".png";

    public AnimationPink(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 20; i++){
            if(type == 9) {
                getAnimation(PINK_GIRL,PNG,i+1,9);
            }
            if(type == 19) {
                getAnimation(PINK_OLD,PNG,i+1,19);
            }
        }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 31; i++){
            if (type == 9) {
                getAnimation(PINK_PUSH_GIRL,PNG, i + 1, 9);
            }
            if (type == 19) {
                getAnimation(PINK_PUSH_OLD,PNG, i + 1, 19);
            }

        }
    }
}
