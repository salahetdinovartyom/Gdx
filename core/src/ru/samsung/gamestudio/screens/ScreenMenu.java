package ru.samsung.gamestudio.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.samsung.gamestudio.MyGdxGame;
import ru.samsung.gamestudio.characters.Bird;
//import ru.samsung.gamestudio.characters.Language;
import ru.samsung.gamestudio.components.MovingBackground;
import ru.samsung.gamestudio.components.TextButton;

public class ScreenMenu implements Screen {
    MyGdxGame myGdxGame;
    MovingBackground background;
    TextButton buttonStart,buttonExit,buttonTerms;
    Bird bird;

    public ScreenMenu(MyGdxGame myGdxGame) {
        this.myGdxGame=myGdxGame;
        background=new MovingBackground("backgrounds/restart_bg.png");
        buttonStart=new TextButton(20,400, "Start");
        buttonExit=new TextButton(20,170,"Exit");
        buttonTerms=new TextButton(790,0,"Terms of use");
        bird=new Bird(700,200,1,500,400);
    }

    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched()) {
            Vector3 touch=myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
            if (buttonStart.isHit((int) touch.x,(int) touch.y))
                myGdxGame.setScreen(myGdxGame.screenGame);
            else if (buttonExit.isHit((int) touch.x,(int) touch.y))
                Gdx.app.exit();
            else if (buttonTerms.isHit((int) touch.x,(int) touch.y)) {
                Gdx.net.openURI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                System.out.println("Да, первое апреля прошло. Ну всё равно же можно оставлять приколы!");
            }


        }
        ScreenUtils.clear(1, 0, 0, 1);
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        myGdxGame.batch.begin();

        background.draw(myGdxGame.batch);
        buttonStart.draw(myGdxGame.batch);
        buttonExit.draw(myGdxGame.batch);
        buttonTerms.draw(myGdxGame.batch);
        bird.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        buttonStart.dispose();
        buttonExit.dispose();
        buttonTerms.dispose();
        bird.dispose();
    }
}
