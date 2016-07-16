package gameobject.Birds;


import java.awt.*;

/**
 * Created by HP on 7/16/2016.
 */
public class Bird {
    public int posX;
    public int posY;
    public int speed;
    AnimationBird animationBird = new AnimationBird();

    public Bird(int x,int y,int speed){
        posX = x;
        posY = y;
        this.speed = speed;
        animationBird = new AnimationBird(11,31);
    }
    public Bird(){}

    public void update(){
        posX += speed;
        animationBird.update();
    }
    public void draw(Graphics g){
        animationBird.draw(g,posX,posY);
    }
}
