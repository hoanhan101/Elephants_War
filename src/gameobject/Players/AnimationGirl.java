package gameobject.Players;

import gameobject.Animations.Animation;

/**
 * Created by HP on 7/16/2016.
 */
public class AnimationGirl extends Animation {
    public static final String GIRL_ATTACK= "Resource/Char101/GirlAttack 16/GirlAttack ";
    public static final String PNG = ".png";

    public AnimationGirl(int type, int time) {
        super(type, time);
    }

    public AnimationGirl(){

    }

    @Override
    public void doAnimation(int type) {
        for (int i = 0; i < 16; i++) {
            getAnimation(GIRL_ATTACK, PNG, i + 1, 2);
        }
    }
}
