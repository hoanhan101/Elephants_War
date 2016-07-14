package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by HP on 7/13/2016.
 */
public class Animation {

    public  String PNG = ".png";
    public  String BOSS_GIRL = "Resource/Char/Boss/Boss " ;
    public  String SMALL_GIRL = "Resource/Char/Blue/Blue " ;
    public  String MID_GIRL = "Resource/Char/Angry/Angry " ;
    public  String BOSS_OLD = "Resource/Char/Boss/Boss " ;
    public  String SMALL_OLD = "Resource/Char/Blue/Blue " ;
    public  String MID_OLD = "Resource/Char/Angry/Angry " ;

    ArrayList<BufferedImage> frames = new ArrayList<>();

    int time;
    int count_time = 0;
    int index;
    int count = 0;
    int posX;
    int posY;
    int strength;
    BufferedImage subImage;

    public Animation(int type,int number_image,int time){
        this.time = time;
        doAnimation(type,number_image);

    }

    private void doAnimation(int type,int number_image){
        for(int i = 0; i < number_image; i++){
            if(type == 1) {
                getAnimation(BOSS_GIRL,PNG,i+1,1);
            }
            if(type == 2) {
                getAnimation(SMALL_GIRL,PNG,i+1,2);
            }
            if(type == 3) {
                getAnimation(MID_GIRL,PNG,i+1,3);
            }
            if(type == 4) {
                getAnimation(BOSS_OLD,PNG,i+1,4);
            }
            if(type == 5) {
                getAnimation(SMALL_OLD,PNG,i+1,5);
            }
            if(type == 6) {
                getAnimation(MID_OLD,PNG,i+1,6);
            }
        }
    }

    private void getAnimation(String str1,String str2,int n,int m) {

        if (m <= 3){
            try {
                subImage = ImageIO.read(new File(str1+n+str2));
                flipImage();
                frames.add(subImage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (m > 3){
            try {
                subImage = ImageIO.read(new File(str1+n+str2));
                frames.add(subImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Rectangle getRectangle(){
        return new Rectangle(posX,posY,frames.get(0).getWidth(),frames.get(0).getHeight());
    }

    public void update(){
        count_time += 20;
        count ++;
        if(count_time > this.time){
            count_time = 0;
            if(index == frames.size() - 1){
                index = 0;
            }else {
                index++;
            }
        }
    }

    public void draw (Graphics g,int posX,int posY){
        g.drawImage(frames.get(index),posX,posY,null);
    }

    void flipImage(){
        AffineTransform tx = AffineTransform.getScaleInstance(-1,1);
        tx.translate(-subImage.getWidth(null),0);
        AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        subImage = op.filter(subImage,null);
    }
}
