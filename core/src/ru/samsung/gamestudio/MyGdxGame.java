package ru.samsung.gamestudio;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.ApplicationAdapter;
// import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	SpriteBatch batch;
    public  static final int SCR_WIDTH = 1280,SCR_HEIGHT = 720;
    public OrthographicCamera camera;
//    Texture birdTexture;
    ScreenGame screenGame;

    @Override
	public void create () {
		batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,SCR_WIDTH,SCR_HEIGHT);
        screenGame=new ScreenGame(this);
        setScreen(screenGame);
		}

	@Override
	public void dispose () {
		batch.dispose();
//        birdTexture.dispose();
	}
}

