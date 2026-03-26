package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.Random;

public class Tube {
    Texture textureUpperTube,textureDownTube;
    int width=200,height=700,gapHeight=400,gapY,padding=100,distanceBetweenTubes,x,speed;
    Random random=new Random();

    public Tube(int tubeCount,int tubeIdx,int speed) {
        gapY=gapHeight/2+padding+random.nextInt(MyGdxGame.SCR_HEIGHT-2*(padding+gapHeight/2));
        distanceBetweenTubes=(MyGdxGame.SCR_WIDTH+width)/(tubeCount-1);
        x=distanceBetweenTubes*tubeIdx+MyGdxGame.SCR_WIDTH;
        this.speed=speed;
        
        textureUpperTube=new Texture("tubes/tube_flipped.png");
        textureDownTube=new Texture("tubes/tube.png");

    }
    void draw(Batch batch) {
        batch.draw(textureUpperTube,x,gapY+gapHeight/2,width,height);
        batch.draw(textureDownTube,x,gapY+gapHeight/2-height,width,height);
    }
    void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }
    void move() {
        x-=speed;
        if (x<=-width) {
            x=MyGdxGame.SCR_WIDTH+distanceBetweenTubes;
            gapY=gapHeight/2+padding+random.nextInt(MyGdxGame.SCR_HEIGHT-2*(padding+gapHeight/2));
        }
    }
}
