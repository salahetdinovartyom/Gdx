package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import ru.samsung.gamestudio.MyGdxGame;

public class Bird {
    Texture texture;
    public int x,y,speed,width,height,jumpHeight,frameCounter;
    final int maxHeightOfJump=200;
    boolean jump;
    Texture[] framesArray;

    public Bird(int x, int y, int speed,int width,int height) {
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.height=height;
        this.width=width;
        frameCounter=0;
        framesArray = new Texture[]{
            new Texture("birdTiles/bird0.png"),
            new Texture("birdTiles/bird1.png"),
            new Texture("birdTiles/bird2.png"),
            new Texture("birdTiles/bird1.png"),
        };
    }

    public void fly() {
        if (y>=jumpHeight) {
            jump=false;
        }
        if (jump) {
            y+=speed;
        } else {
            y-=speed;
        }
    }
    public void onClick() {
        jump=true;
        jumpHeight=maxHeightOfJump+y;
    }
    public boolean isInField(){
        if (y+height<0) return false;
        return y <= MyGdxGame.SCR_HEIGHT;
    }
    public void draw(Batch batch) {
        int frameMultiplier=5;
        batch.draw(framesArray[frameCounter/frameMultiplier],x,y,width,height);
        if (frameCounter++ == framesArray.length * frameMultiplier - 1) frameCounter=0;
    }
    public void dispose() {
        texture.dispose();
    }

}
