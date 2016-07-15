package gameobject.Menu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 7/15/2016.
 */
public class Intruction extends Screen {
    public static final String BACKGROUND = "Resource/Background/Instruction 1.png";
    public static final String BUTTON_INTRUCTION = "Resource/Char101/Button/ButtonBack.png";
    public static final String BUTTON_NEXT = "Resource/Char101/Button/ButtonNext.png";

    BufferedImage image;
    BufferedImage background;
    BufferedImage next;

    @Override
    public void clickButton(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(50,630,image)))
            ManagerMenu.getInstance().getStackScreen().pop();
        if(mouse.getRectangleButton().intersects(getRectangleButton(870,630,next)))
            ManagerMenu.getInstance().getStackScreen().push(new Instruction2());
    }

    @Override
    public void update() {
    }
    public Rectangle getRectangleButton(int x,int y,BufferedImage image_){
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }

    @Override
    public int Collision(Mouse mouse) {
       try {
           if (mouse.getRectangleButton().intersects(getRectangleButton(50, 630, image))) {
               return 1;
           }
           if (mouse.getRectangleButton().intersects(getRectangleButton(870, 630, next))) {
               return 1;
           }
       }catch (Exception e){
           return 0;
       }
        return 0;
    }

    @Override
    public void draw(Graphics g) {
        try {
            image= ImageIO.read(new File(BUTTON_INTRUCTION));
            background = ImageIO.read(new File(BACKGROUND));
            next = ImageIO.read(new File(BUTTON_NEXT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(background,0,0,null);
        g.drawImage(image,50,630,null);
        g.drawImage(next,870,630,null);
    }
}
