package gameobject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP on 7/14/2016.
 */
public class AnimationBlue extends Animation {
    public  static final String BLUE_GIRL = "Resource/Char101/Blue 20/Blue " ;
    public  static final String BLUE_OLD = "Resource/Char101/Blue 20/Blue " ;
    public  static final String BLUE_PUSH_GIRL = "Resource/Char101/BluePush 30/BluePush ";
    public  static final String BLUE_PUSH_OLD = "Resource/Char101/BluePush 30/BluePush " ;
    public  static final String PNG = ".png";

    ArrayList<BufferedImage> framePush = new ArrayList<>();

    public AnimationBlue(int type, int time) {
        super(type, time);
    }

    @Override
    public void doAnimation(int type) {
            for (int i = 0; i < 20; i++) {
                if (type == 1) {
                    getAnimation(BLUE_GIRL, PNG, i + 1, 1);
                }
                if (type == 11) {
                    getAnimation(BLUE_OLD, PNG, i + 1, 11);
                }
            }
    }

    public void doPushAnimation(int type){
        for(int i = 0; i < 30; i++){
                if (type == 1) {
                    getAnimation(BLUE_PUSH_GIRL,PNG, i + 1, 1);
                }
                if (type == 11) {
                    getAnimation(BLUE_PUSH_OLD,PNG, i + 1, 11);
                }

        }
    }

}
