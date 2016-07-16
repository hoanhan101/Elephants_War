package gameobject.Players;

import gameobject.Animations.Animation;

/**
 * Created by HP on 7/16/2016.
 */
public class AnimationOld extends Animation {
    public static final String OLD_ATTACK= "Resource/Char101/OldAttack 18/OldAttack ";
    public static final String PNG = ".png";

    public AnimationOld(int type, int time) {
        super(type, time);
    }

    public AnimationOld(){

    }

    @Override
    public void doAnimation(int type) {
        for (int i = 0; i < 17; i++) {
            getAnimation(OLD_ATTACK, PNG, i + 1, 11);
        }
    }
}
