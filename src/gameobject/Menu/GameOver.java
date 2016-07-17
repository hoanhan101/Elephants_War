package gameobject.Menu;

import gameobject.Animations.Animation;
import gameobject.Players.AnimationGirl;
import gameobject.Players.AnimationOld;
import gameobject.Singleton.ManagerGameOver;
import gameobject.Singleton.ManagerMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 7/16/2016.
 */
public class GameOver extends Screen {
    public static final String nam = "Resource/Background/Background.jpg";
    public static final String PLAYER_GIRL = "Resource/Char/1Girl.png";
    public  static final String buttun = "Resource/Char101/Button/ButtonPlayAgain.png";
    public static final String PLAYER_OLDMAN = "Resource/Char/2OldMan.png";
    int k;
    public AnimationGirl animationGirl = new AnimationGirl();
    public AnimationOld animationOld = new AnimationOld();
    BufferedImage sprite;
    public GameOver(int n){
        k = n;
    }
    @Override
    public void clickButton(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(50,630,sprite)))
            System.exit(0);
    }

    @Override
    public void update() {

    }



    public void draw(Graphics g) {
        try {
            sprite = ImageIO.read(new File(buttun));
            g.drawImage(ImageIO.read(new File(nam)),0,0,null);
            g.drawImage(sprite,50,630,null);
        if(k == 1 ){
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(new Font("Calibri",Font.BOLD,100));
            g2.setColor(Color.RED);
            g2.drawString("WINNER",350,250);
           animationGirl = new AnimationGirl(2,31);
//           g.drawImage(ImageIO.read(new File(PLAYER_GIRL)),500,300,null);
//            g.drawString("1",300,300);
    //        ManagerGameOver.getInstance().setA(1);
            animationGirl.draw(g,450,350);
            animationGirl.update();
        }

            if(k == 2) {
//                animationOld = new AnimationOld(11,31);
//                ManagerGameOver.getInstance().setA(2);
//                g.drawImage(ImageIO.read(new File(PLAYER_GIRL)),500,300,null);
//                animationOld.draw(g,550,350);
//                animationOld.update();
                Graphics2D g2 = (Graphics2D)g;
                g2.setFont(new Font("Calibri",Font.BOLD,10));
                g2.setColor(Color.RED);
                g2.drawString("WINNER",350,250);
                animationOld = new AnimationOld(11,31);
                animationOld.draw(g,450,350);
                animationOld.update();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Rectangle getRectangleButton(int x, int y, BufferedImage image) {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }

    @Override
    public int Collision(Mouse mouse) {
        return 0;
    }
}
