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
    public static final String BACKGROUND = "Resource/Background/Background.jpg";
    public static final String BUTTON_INTRUCTION = "Resource/Char101/Button/ButtonBack.png";

    BufferedImage image;
    BufferedImage background;

    @Override
    public void clickButton(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(50,600,image)))
            ManagerMenu.getInstance().getStackScreen().pop();
    }

    @Override
    public void update() {
    }
    public Rectangle getRectangleButton(int x,int y,BufferedImage image_){
        return new Rectangle(50,600,image.getWidth(),image.getHeight());
    }

    @Override
    public int Collision(Mouse mouse) {
       try {
           if (mouse.getRectangleButton().intersects(getRectangleButton(50, 600, image))) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(background,0,0,null);
        g.drawImage(image,50,600,null);

    }
}
