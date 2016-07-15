package gameobject.Animations;

/**
 * Created by hoanhan on 7/15/16.
 */
public class AnimationStupid extends Animation {
    public  static final String STUPID_GIRL = "Resource/Char101/Stupid 15/Stupid " ;
    public  static final String STUPID_OLD = "Resource/Char101/Stupid 15/Stupid " ;
    public  static final String STUPID_PUSH_GIRL = "Resource/Char101/StupidPush 25/StupidPush " ;
    public  static final String STUPID_PUSH_OLD = "Resource/Char101/StupidPush 25/StupidPush " ;
    public  static final String PNG = ".png";

    public AnimationStupid(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
        for(int i = 0; i < 15; i++){
            if(type == 6) {
                getAnimation(STUPID_GIRL,PNG,i+1,6);
            }
            if(type == 16) {
                getAnimation(STUPID_OLD,PNG,i+1,16);
            }
        }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 25; i++){
            if (type == 6) {
                getAnimation(STUPID_PUSH_GIRL,PNG, i + 1, 6);
            }
            if (type == 16) {
                getAnimation(STUPID_PUSH_OLD,PNG, i + 1, 16);
            }

        }
    }
}
