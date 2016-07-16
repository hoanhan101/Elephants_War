package gameobject.Menu;

import gameobject.Singleton.ManagerMenu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 7/15/2016.
 */
public class Instruction2 extends Screen {

        public static final String BACKGROUND = "Resource/Background/Instruction 2.png";
        public static final String BUTTON_INTRUCTION = "Resource/Char101/Button/ButtonBack.png";


        BufferedImage image;
        BufferedImage background;

        @Override
        public void clickButton(Mouse mouse) {
            if(mouse.getRectangleButton().intersects(getRectangleButton(750,630,image)))
                ManagerMenu.getInstance().getStackScreen().pop();
        }

        @Override
        public void update() {
        }
        public Rectangle getRectangleButton(int x, int y, BufferedImage image_){
            return new Rectangle(750,630,image.getWidth(),image.getHeight());
        }

        @Override
        public int Collision(Mouse mouse) {
            try {
                if (mouse.getRectangleButton().intersects(getRectangleButton(750, 630, image))) {
                    return 1;
                }
                if (mouse.getRectangleButton().intersects(getRectangleButton(0, 0, background))) {
                    return 0;
                }
            }catch (Exception e){

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
            g.drawImage(image,750,630,null);
        }
}

