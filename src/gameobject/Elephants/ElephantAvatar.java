package gameobject.Elephants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 7/16/2016.
 */
public class ElephantAvatar {
    public static final String Angry = "Resource/Char101/AnimalAvatar/Angry.png";
    public static final String Blue = "Resource/Char101/AnimalAvatar/Blue.png";
    public static final String Stupid = "Resource/Char101/AnimalAvatar/Stupid.png";
    public static final String Boss2 = "Resource/Char101/AnimalAvatar/Boss2.png";
    public static final String BigBrown = "Resource/Char101/AnimalAvatar/Brown.png";
    public static final String Pink = "Resource/Char101/AnimalAvatar/image347.png";
    public static final String Green = "Resource/Char101/AnimalAvatar/image348.png";
    public static final String Brown = "Resource/Char101/AnimalAvatar/image350.png";
    public static final String Boss1 = "Resource/Char101/AnimalAvatar/image351.png";

    public ElephantAvatar(int m,int n , Graphics g){
        if(m == 1)
        try {
        switch(n){
            case 2 :
                g.drawImage(ImageIO.read(new File(Angry)),30,30,null);
                break;
            case 4 :
                g.drawImage(ImageIO.read(new File(Blue)),30,30,null);
                break;
            case 3 :
                g.drawImage(ImageIO.read(new File(Boss1)),30,30,null);
                break;
            case 1 :
                g.drawImage(ImageIO.read(new File(Boss2)),30,30,null);
                break;
            case 5 :
                g.drawImage(ImageIO.read(new File(Brown)),30,30,null);
                break;
            case 9 :
                g.drawImage(ImageIO.read(new File(Pink)),30,30,null);
                break;
            case 6 :
                g.drawImage(ImageIO.read(new File(Stupid)),30,30,null);
                break;
            case 8 :
                g.drawImage(ImageIO.read(new File(Green)),30,30,null);
                break;
            case 7 :
                g.drawImage(ImageIO.read(new File(BigBrown)),30,30,null);
                break;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(m == 2)
            try {
                switch(n){
                    case 2 :
                        g.drawImage(ImageIO.read(new File(Angry)),900,30,null);
                        break;
                    case 4 :
                        g.drawImage(ImageIO.read(new File(Blue)),900,30,null);
                        break;
                    case 3 :
                        g.drawImage(ImageIO.read(new File(Boss1)),900,30,null);
                        break;
                    case 1 :
                        g.drawImage(ImageIO.read(new File(Boss2)),900,30,null);
                        break;
                    case 5 :
                        g.drawImage(ImageIO.read(new File(Brown)),900,30,null);
                        break;
                    case 9 :
                        g.drawImage(ImageIO.read(new File(Pink)),900,30,null);
                        break;
                    case 6 :
                        g.drawImage(ImageIO.read(new File(Stupid)),900,30,null);
                        break;
                    case 8 :
                        g.drawImage(ImageIO.read(new File(Green)),900,30,null);
                        break;
                    case 7 :
                        g.drawImage(ImageIO.read(new File(BigBrown)),900,30,null);
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
