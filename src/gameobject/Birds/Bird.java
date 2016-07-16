package gameobject.Birds;


import java.awt.*;

/**
 * Created by HP on 7/16/2016.
 */
public class Bird {
    public int posX;
    public int posY;
    public double speed;
    AnimationBird animationBird = new AnimationBird();

    public Bird(int x,int y,double speed){
        posX = x;
        posY = y;
        this.speed = speed;
        animationBird = new AnimationBird(11,40);
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
