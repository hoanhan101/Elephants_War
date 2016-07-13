package gameobject;

import javax.imageio.ImageIO;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Player {
    public static final int TYPE_PLAYER_1 = 1;
    public static final int TYPE_PLAYER_2 = 2;
    public static final String PLAYER_GIRL_1 = "Resource/Char/1Girl.png";
    public static final String PLAYER_GIRL_2 = "Resource/Char/2Girl.png";

    private BufferedImage sprite;
    private int posX;
    protected  ArrayList<Elephant> listElephant = new ArrayList<>();
    Random random = new Random();

    public Player(int posX, int type){
        posX = posX;
        loadSpriteByType(type);
    }

    private void loadSpriteByType(int type) {
        switch (type) {
            case 1:
                try {
                    sprite = ImageIO.read(new File(PLAYER_GIRL_1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    sprite = ImageIO.read(new File(PLAYER_GIRL_2));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    protected void callElephant(int x,int number_player){
        if(number_player == 1){
            int n = random.nextInt(6);
            int m = n + 1;
            if(m%2 == 0) {
                m -= 1;
                listElephant.add(new Elephant(x,m));
            }else listElephant.add(new Elephant(x,m));
        }
        if(number_player == 2){
            int n = random.nextInt(6);
            int m = n + 1;
            if(m%2 != 0) {
                m += 1;
                listElephant.add(new Elephant(x,m));
            }else listElephant.add(new Elephant(x,m));
        }
    }
}
