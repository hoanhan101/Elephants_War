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

/**
 * Created by HP on 7/13/2016.
 */
public class Animation {
    ArrayList<BufferedImage> frames = new ArrayList<>();

    int time;
    int count_time = 0;
    int index;
    BufferedImage subImage;

    public Animation(int type,int number_image,int time){
        this.time = time;
        doAnimation(type,number_image);

    }

    private void doAnimation(int type,int number_image){
        for(int i = 0; i < number_image; i++){
            if(type == 1) {
                try {
                    subImage = ImageIO.read(new File("Resource/Char/Boss/Boss " + (i + 1) + ".png"));
                    flipImage();
                    frames.add(subImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(type == 2) {
                try {
                    subImage = ImageIO.read(new File("Resource/Char/Blue/Blue " + (i + 1) + ".png"));
                    flipImage();
                    frames.add(subImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(type == 3) {
                try {
                    subImage = ImageIO.read(new File("Resource/Char/Angry/Angry " + (i + 1) + ".png"));
                    flipImage();
                    frames.add(subImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void update(){
        count_time += 20;
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
