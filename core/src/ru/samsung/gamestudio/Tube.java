package ru.samsung.gamestudio;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import java.util.Random;
import static ru.samsung.gamestudio.MyGdxGame.SCR_HEIGHT;
import static ru.samsung.gamestudio.MyGdxGame.SCR_WIDTH;
public class Tube {
    Texture textureUpperTube,textureDownTube;
    int gapHeight=400,speed=10,gapY,padding=100,distanceBetweenTubes,x;
    final int width=200,height=700;
    Random random;
    boolean isPointReceived;

    public Tube(int tubeCount,int tubeIdx) {
        random=new Random();
        gapY=gapHeight/2+padding+random.nextInt(SCR_HEIGHT-2*(padding+gapHeight/2));
        distanceBetweenTubes=(SCR_WIDTH+width) / (tubeCount-1);
        x=distanceBetweenTubes*tubeIdx+SCR_WIDTH;
        isPointReceived=false;
        textureUpperTube=new Texture("tubes/tube_flipped.png");
        textureDownTube=new Texture("tubes/tube.png");
    }
    void draw(Batch batch) {
        batch.draw(textureUpperTube,x,gapY+ (float) gapHeight /2,width,height);
        batch.draw(textureDownTube,x,gapY- (float) gapHeight /2-height-padding,width,height);
    }
    void dispose() {
        textureDownTube.dispose();
        textureUpperTube.dispose();
    }
    void move() {
        x-=speed;
        if (x<-width) {
            isPointReceived=false;
            x=SCR_WIDTH+distanceBetweenTubes;
            gapY=gapHeight/2+padding+random.nextInt(SCR_HEIGHT-2*(padding+gapHeight/2));
        }
    }
    public boolean isHit(Bird bird) {
        if (bird.x+bird.width>=x && bird.x<=x+width && bird.y<=gapY-gapHeight/2) return true;
        return bird.y + bird.height >= gapY + gapHeight / 2 && bird.x + bird.width >= x && bird.x <= x;
    }
    public boolean needAddPoint(Bird bird) {
        return (bird.x<x+width && !isPointReceived);
    }
}
