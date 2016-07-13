package gameobject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP on 7/13/2016.
 */
public class Animation {
    private ArrayList<BufferedImage> frames = new ArrayList<>();

    int time;
    int count_time = 0;
    int index;

    public Animation(String imageRS,int number_image,int time){
        this.time = time;
        for(int i = 0; i < number_image; i++){
            try {
                BufferedImage subImage = ImageIO.read(new File(imageRS));
                frames.add(subImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        count_time ++;
        if(count_time > this.time){
            count_time = 0;
            if(index == frames.size() - 1){
                index = 0;
            }else{
                index ++;
            }
        }
    }

    public void draw (Graphics g,int posX,int posY){
        g.drawImage(frames.get(index),posX,posY,null);
    }
}
