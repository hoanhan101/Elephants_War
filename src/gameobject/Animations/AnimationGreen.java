package gameobject.Animations;

/**
 * Created by hoanhan on 7/15/16.
 */
public class AnimationGreen extends Animation {
    public  static final String GREEN_GIRL = "Resource/Char101/Green 11/Green " ;
    public  static final String GREEN_OLD = "Resource/Char101/Green 11/Green " ;
    public  static final String GREEN_PUSH_GIRL = "Resource/Char101/GreenPush 38/GreenPush " ;
    public  static final String GREEN_PUSH_OLD = "Resource/Char101/GreenPush 38/GreenPush " ;
    public  static final String PNG = ".png";

    public AnimationGreen(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 11; i++){
            if(type == 8) {
                getAnimation(GREEN_GIRL,PNG,i+1,8);
            }
            if(type == 18) {
                getAnimation(GREEN_OLD,PNG,i+1,18);
            }
        }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 38; i++){
            if (type == 8) {
                getAnimation(GREEN_PUSH_GIRL,PNG, i + 1, 8);
            }
            if (type == 18) {
                getAnimation(GREEN_PUSH_OLD,PNG, i + 1, 18);
            }
        }
    }
}
