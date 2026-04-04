package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.characters.Bird;
import ru.samsung.gamestudio.characters.Tube;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.PointCounter;
//import com.badlogic.gdx.graphics.Texture;

public class ScreenGame implements Screen {
    MyGdxGame myGdxGame;
    Bird bird;
    Tube[] tubes;
    PointCounter pointCounter;
    MovingBackground background;
    final int pointCounterMarginTop=60,pointCounterMarginRight=400;
    int tubeCount=3,gamePoints;
    boolean isGameOver;
    public ScreenGame(MyGdxGame myGdxGame) {
        this.myGdxGame=myGdxGame;
        bird=new Bird(0,360,5,250,200);
        initTubes();
        pointCounter=new PointCounter(MyGdxGame.SCR_WIDTH -pointCounterMarginRight,MyGdxGame.SCR_HEIGHT-pointCounterMarginTop);
        background=new MovingBackground("backgrounds/game_bg.png");
    }

    @Override
    public void show() {
        isGameOver=false;
        bird.y=MyGdxGame.SCR_HEIGHT/2;
        initTubes();
        gamePoints = 0;
    }

    @Override
    public void render(float delta) {
        if (isGameOver) {
            myGdxGame.screenRestart.gamePoints=gamePoints;
            myGdxGame.setScreen(myGdxGame.screenRestart);
        }
        if (Gdx.input.justTouched()) {
            bird.onClick();
        }
        background.move();
        bird.fly();

        if (!bird.isInField()) {
            isGameOver=true;
        }
        for (Tube tube:tubes) {
            tube.move();
            if (tube.isHit(bird)) {
                isGameOver=true;
            } else if (tube.needAddPoint(bird)) {
                gamePoints++;
                tube.setPointReceived();
                System.out.println(gamePoints);
            }
        }
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);
        for (Tube tube:tubes) tube.draw(myGdxGame.batch);
        pointCounter.draw(myGdxGame.batch,gamePoints);

        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        bird.dispose();
        pointCounter.dispose();
        for (int i=0;i<tubeCount;i++) {
            tubes[i].dispose();
        }
        background.dispose();
    }

    void initTubes() {
        tubes = new Tube[tubeCount];
        for (int i=0;i<tubeCount;i++) {
            tubes[i]=new Tube(tubeCount,i);
        }
    }
}
