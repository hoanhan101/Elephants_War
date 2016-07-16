package gameobject.Birds;

import gameobject.Animations.Animation;

/**
 * Created by HP on 7/16/2016.
 */
public class AnimationBird extends Animation {
    public static final String BIRD = "Resource/Char101/Bird/Bird ";
    public static final String PNG = ".png";

    public AnimationBird(int type, int time) {
        super(type, time);
    }

    public AnimationBird(){

    }

    @Override
    public void doAnimation(int type) {
        for (int i = 0; i < 2; i++) {
                getAnimation(BIRD, PNG, i + 1, 11);
        }
    }
}
