package gameobject.Menu;

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
    public static final String girl = "Resource/Background/GirlWin4.jpg";
    public static final String nam = "Resource/Background/ManWin2.jpg";
    public  static final String buttun = "Resource/Char101/Button/ButtonBack.png";
    int k;
    BufferedImage sprite;
    public GameOver(int n){
        k = n;
    }
    @Override
    public void clickButton(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(50,630,sprite)))
            ManagerMenu.getInstance().getStackScreen().pop();
    }

    @Override
    public void update() {

    }



    public void draw(Graphics g) {
        try {
        if(k == 1)
            g.drawImage(ImageIO.read(new File(girl)),0,0,null);
            if(k == 2) g.drawImage(ImageIO.read(new File(nam)),0,0,null);
            sprite = ImageIO.read(new File(buttun));
            g.drawImage(sprite,50,630,null);
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
