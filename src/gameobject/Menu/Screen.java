package gameobject.Menu;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by HP on 7/15/2016.
 */
public abstract class Screen {
    public abstract void clickButton(Mouse mouse);
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract Rectangle getRectangleButton(int x,int y,BufferedImage image);
    public abstract int Collision(Mouse mouse);
}
