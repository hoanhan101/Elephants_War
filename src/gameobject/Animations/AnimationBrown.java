package gameobject.Animations;

/**
 * Created by hoanhan on 7/15/16.
 */
public class AnimationBrown extends Animation {
    public  static final String BROWN_GIRL = "Resource/Char101/Brown 26/Brown " ;
    public  static final String BROWN_OLD = "Resource/Char101/Brown 26/Brown " ;
    public  static final String BROWN_PUSH_GIRL = "Resource/Char101/BrownPush 37/BrownPush " ;
    public  static final String BROWN_PUSH_OLD = "Resource/Char101/BrownPush 37/BrownPush " ;
    public  static final String PNG = ".png";

    public AnimationBrown(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 26; i++){
            if(type == 5) {
                getAnimation(BROWN_GIRL,PNG,i+1,5);
            }
            if(type == 15) {
                getAnimation(BROWN_OLD,PNG,i+1,15);
            }
        }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 37; i++){
            if (type == 5) {
                getAnimation(BROWN_PUSH_GIRL,PNG, i + 1, 5);
            }
            if (type == 15) {
                getAnimation(BROWN_PUSH_OLD,PNG, i + 1, 15);
            }

        }
    }
}
