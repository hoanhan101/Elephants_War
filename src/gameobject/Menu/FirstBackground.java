package gameobject.Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 7/15/2016.
 */
public class FirstBackground extends Screen{
    public static final String MENU_BACKGROUD = "Resource/Char101/GameMenu/GameMenuBackground.jpg";
    public static final String MENU_NAME = "Resource/Char101/GameMenu/GameMenuName.png";
    public static final String BUTTON_START = "Resource/Char101/Button/ButtonStart.png";
    public static final String BUTTON_OTHERGAME = "Resource/Char101/Button/ButtonOtherGame.png";
    public static final String BUTTON_INTRUTION = "Resource/Char101/Button/ButtonIntruction.png";

    public static final int POSITION_START_X= 400;
    public static final int POSITION_START_Y= 590;
    public static final int POSITION_OTHER_GAME_X = 70;
    public static final int POSITION_OTHER_GAME_Y = 570;
    public static final int POSITION_INTRUDUCTION_X= 700;
    public static final int POSITION_INTRUDUCTION_Y= 590;
    public static final int POSITION_NAME_X= 100;
    public static final int POSITION_NAME_Y= 250;

    BufferedImage menuBackground;
    BufferedImage menuName;
    BufferedImage buttonStart;
    BufferedImage buttonOtherGame;
    BufferedImage buttonIntruction;

    public FirstBackground(){
        loadImage();
    }
    @Override
    public void clickButton(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_START_X,POSITION_START_Y,buttonStart))) {
            ManagerMenu.getInstance().getStackScreen().push(new GamePlay());
        }

        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_OTHER_GAME_X,POSITION_OTHER_GAME_Y,buttonOtherGame)))
            System.exit(0);
        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_INTRUDUCTION_X,POSITION_INTRUDUCTION_Y,buttonIntruction)))
            ManagerMenu.getInstance().getStackScreen().push(new Intruction());
    }

    @Override
    public void update() {

    }
    public void loadImage(){
        try {
            menuBackground = ImageIO.read(new File(MENU_BACKGROUD));
            menuName = ImageIO.read(new File(MENU_NAME));
            buttonStart = ImageIO.read(new File(BUTTON_START));
            buttonOtherGame = ImageIO.read(new File(BUTTON_OTHERGAME));
            buttonIntruction = ImageIO.read(new File(BUTTON_INTRUTION));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Rectangle getRectangleButton(int x,int y,BufferedImage sprite){
        return new Rectangle(x,y,sprite.getWidth(),sprite.getHeight());
    }

    @Override
    public int Collision(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_START_X,POSITION_START_Y,buttonStart))) {
            return 1;
        }
        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_OTHER_GAME_X,POSITION_OTHER_GAME_Y,buttonOtherGame))){
            return 1;
        }
        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_INTRUDUCTION_X,POSITION_INTRUDUCTION_Y,buttonIntruction))) {
            return 1;
        }
        return 0;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(menuBackground,0,0,null);
        g.drawImage(menuName,POSITION_NAME_X,POSITION_NAME_Y,null);
        g.drawImage(buttonStart,POSITION_START_X,POSITION_START_Y,null);
        g.drawImage(buttonOtherGame,POSITION_OTHER_GAME_X,POSITION_OTHER_GAME_Y,null);
        g.drawImage(buttonIntruction,POSITION_INTRUDUCTION_X,POSITION_INTRUDUCTION_Y,null);
    }
}
