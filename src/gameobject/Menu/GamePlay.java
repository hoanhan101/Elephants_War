package gameobject.Menu;

import gameobject.Birds.Bird;
import gameobject.Elephants.ElephantAvatar;
import gameobject.Items.Item;
import gameobject.Players.AnimationGirl;
import gameobject.Players.Player;
import gameobject.Players.PlayerGirl;
import gameobject.Players.PlayerOld;
import gameobject.Singleton.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HP on 7/15/2016.
 */
public class GamePlay extends Screen {
    public static final String BACKGROUND = "Resource/Background/Background.jpg";
    public static final String BUTTON_BACK = "Resource/Char101/Button/ButtonBack.png";
    public static final int playerHeight1 = 75;
    public static final int playerHeight2 = 80;
    public static final int count_keyWord = 100;
    public static final int POSITION_BACK_X= 50;
    public static final int POSITION_BACK_Y= 620;
    BufferedImage background;
    BufferedImage buttonBack;
    Bird bird = new Bird();
    Item item = new Item();
    Player playerGril ;
    Player playerOld;

    int count_keyWord_1 = 100;
    int count_keyWord_2 = 100;
    int count_girl;
    int count_old;
    int count_bird = 0;
    int n;
    int v;
    boolean a;
    boolean b;
    ElephantAvatar elephantAvatar;
    ElephantAvatar elephantAvatar2;
    Random random = new Random();
    int x;
    int  k,m,t,h,f;
    ArrayList<Item> listItem = new ArrayList<>();
    public GamePlay(){
        initPlayer();
    }

    public void initPlay(char keyChar) {
        switch (keyChar){
            case 'd':
                if(count_keyWord_2 >= count_keyWord) {
                    v = 1;
                    playerGril.call(x+3);
                    ManagerGirl.getInstance().setAnimationGirl(1);
                    count_keyWord_2 = 0;
                }
                break;
            case 's':
                if(ManagerWay.getInstance().getWay() <= 500) {
                    ManagerWay.getInstance().setWay(ManagerWay.getInstance().getWay() + 100);
                    playerGril.setPosY(ManagerWay.getInstance().getWay() - playerHeight1);
                }
                break;
            case 'w':
                if(ManagerWay.getInstance().getWay() >= 300) {
                    ManagerWay.getInstance().setWay(ManagerWay.getInstance().getWay() - 100);
                    playerGril.setPosY(ManagerWay.getInstance().getWay() - playerHeight1);
                }
                break;
        }
    }

    @Override
    public void clickButton(Mouse mouse) {
        if(mouse.getRectangleButton().intersects(getRectangleButton(POSITION_BACK_X,POSITION_BACK_Y,buttonBack))) {
            ManagerMenu.getInstance().getStackScreen().pop();
        }
    }

    @Override
    public void update() {
        if(v ==1) {
            x = random.nextInt(6);
            ManagerCall.getInstance().setBefore(x+3);
            v = 0;
        }
        if(h == 1){
            f = random.nextInt(6);
            ManagerCall.getInstance().setBeforeMan(f+3);
            h = 0;
        }
        n =  ManagerGirl.getInstance().getAnimationGirl();
        m =  ManagerOld.getInstance().getAnimationOld();
        count_keyWord_1++;
        count_keyWord_2++;
        count_bird++;
        playerGril.update(1);
        playerOld.update(2);
        if(playerGril.listElephant.size() > 0 && playerOld.listElephant.size() > 0)
            playerGril.checkCollision(playerOld);

        if(count_bird  == 1000){
            bird = new Bird(900,50,-0.5);
            item = new Item(900,50,-2);
            listItem.add(item);
            count_bird = 0;
        }
        if(n == 1){
            count_girl++;
            if(count_girl == 75){
                ManagerGirl.getInstance().setAnimationGirl(0);
                count_girl = 0;
            }

        }
        if(m == 2){
            count_old++;
            if(count_old == 80){
                ManagerOld.getInstance().setAnimationOld(0);
                count_old = 0;
            }

        }
        if(bird != null) bird.update();
        check_Collision();
        k =ManagerCall.getInstance().getBefore();
        t =ManagerCall.getInstance().getBeforeMan();
        overGame();

    }

    public void overGame(){
        int a = ManagerScore.getInstance().getScore1();
        int b = ManagerScore.getInstance().getScore2();
        if (a == 1){
            ManagerMenu.getInstance().getStackScreen().push(new GameOver(1));
            ManagerScore.getInstance().setScore1(0);
        }
        if (b == 1){
            ManagerMenu.getInstance().getStackScreen().push(new GameOver(2));
            ManagerScore.getInstance().setScore2(0);
        }
    }

    private void initPlayer() {
        playerGril = new PlayerGirl(0,ManagerWay.getInstance().getWay() - playerHeight1,PlayerGirl.TYPE_PLAYER_GIRL);
        playerOld = new PlayerOld(900, ManagerWay2.getInstance().getWay() - playerHeight2,PlayerOld.TYPE_PLAYER_OLD);
    }

    public Rectangle getRectangleButton(int x,int y,BufferedImage image){
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }

    @Override
    public int Collision(Mouse mouse) {
        try {
            if (mouse.getRectangleButton().intersects(getRectangleButton(POSITION_BACK_X, POSITION_BACK_Y, buttonBack))) {
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
            background = ImageIO.read(new File(BACKGROUND));
            buttonBack = ImageIO.read(new File(BUTTON_BACK));
        } catch (IOException e) {
            e.printStackTrace();
        }

            g.drawImage(background,0,0,null);
            g.drawImage(buttonBack,POSITION_BACK_X,POSITION_BACK_Y,null);



        if(n == 1){
            ((PlayerGirl)playerGril).animationGirl.draw(g,playerGril.posX,playerGril.posY);
            ((PlayerGirl)playerGril).animationGirl.update();
        }
        if(m == 2){
            ((PlayerOld)playerOld).animationOld.draw(g,playerOld.posX,playerOld.posY);
            ((PlayerOld)playerOld).animationOld.update();
        }
        playerGril.draw(g);
        playerOld.draw(g);

        if(bird != null){
            bird.draw(g);
        }
        elephantAvatar = new ElephantAvatar(1,k+1,g);
        elephantAvatar2 = new ElephantAvatar(2,t+1,g);
        if(listItem.size() > 0)
            for(int i = 0; i < listItem.size();i++){
                listItem.get(i).draw(g,listItem.get(i).sprite);
                listItem.get(i).update();
            }
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(new Font("Calibri",Font.BOLD,50));
            g2.setColor(Color.RED);
            g2.drawString(ManagerScore.getInstance().getScore1()+"",400,100);
            g2.drawString(ManagerScore.getInstance().getScore2()+"",550,100);
            g2.setColor(Color.ORANGE);
            g2.drawString(ManagerTime.getInstance().getTime()+"",450,80);
    }
    public void check_Collision(){
        try{
        if(listItem.size() > 0 && playerGril.listElephant.size() > 0){
            for(int i = 0; i < listItem.size(); i++){
                for(int j = 0; j < playerGril.listElephant.size(); j++){
                    if(listItem.get(i).getRectangle().intersects(playerGril.listElephant.get(j).animation.getRectangle())){
                        if(listItem.get(i).sprite == Item.angry) {
                            ManagerAngry.getInstance().setHas_eat(true);
                            ManagerAngry.getInstance().setGirl_eat(true);
                            listItem.remove(i);
                        }
                        if(listItem.get(i).sprite == Item.boss1) {
                            ManagerBoss1.getInstance().setHas_eat(true);
                            ManagerBoss1.getInstance().setGirl_eat(true);
                            listItem.remove(i);
                        }
                        if(listItem.get(i).sprite == Item.boss2) {
                            ManagerBoss2.getInstance().setHas_eat(true);
                            ManagerBoss2.getInstance().setGirl_eat(true);
                            listItem.remove(i);
                        }
                        if(listItem.get(i).sprite == Item.boss3) {
                            ManagerFire.getInstance().setHas_eat(true);
                            ManagerFire.getInstance().setGirl_eat(true);
                            a = ManagerFire.getInstance().isHas_eat();
                            b = ManagerFire.getInstance().isGirl_eat();
                            listItem.remove(i);
                        }
                    }
                }
            }
        }

        if(listItem.size() > 0 && playerOld.listElephant.size() > 0){
            for(int i = 0; i < listItem.size(); i++){
                for(int j = 0; j < playerOld.listElephant.size(); j++){
                    if(listItem.get(i).getRectangle().intersects(playerOld.listElephant.get(j).animation.getRectangle())){
                        if(listItem.get(i).sprite == Item.angry) {
                            ManagerAngry.getInstance().setHas_eat(true);
                            ManagerAngry.getInstance().setOld_eat(true);
                            listItem.remove(i);
                        }
                        if(listItem.get(i).sprite == Item.boss1) {
                            ManagerBoss1.getInstance().setHas_eat(true);
                            ManagerBoss1.getInstance().setOld_eat(true);
                            listItem.remove(i);
                        }
                        if(listItem.get(i).sprite == Item.boss2) {
                            ManagerBoss2.getInstance().setHas_eat(true);
                            ManagerBoss2.getInstance().setOld_eat(true);
                            listItem.remove(i);
                        }
                        if(listItem.get(i).sprite == Item.boss3) {
                            ManagerFire.getInstance().setHas_eat(true);
                            ManagerFire.getInstance().setOld_eat(true);
                            listItem.remove(i);
                        }
                    }
                }
            }
        }}catch (Exception e){

        }
    }

    public void initPlay2(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (count_keyWord_1 >= count_keyWord) {
                    h = 1;
                    playerOld.call(f+3);
                    ManagerOld.getInstance().setAnimationOld(2);
                    count_keyWord_1 = 0;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(ManagerWay2.getInstance().getWay() <= 500) {
                    ManagerWay2.getInstance().setWay(ManagerWay2.getInstance().getWay() + 100);
                    playerOld.setPosY(ManagerWay2.getInstance().getWay() - playerHeight1);
                }
                break;
            case KeyEvent.VK_UP:
                if(ManagerWay2.getInstance().getWay() >= 300) {
                    ManagerWay2.getInstance().setWay(ManagerWay2.getInstance().getWay() - 100);
                    playerOld.setPosY(ManagerWay2.getInstance().getWay() - playerHeight1);
                }
                break;
        }
    }
}
