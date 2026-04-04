package ru.samsung.gamestudio;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.samsung.gamestudio.characters.Language;
import ru.samsung.gamestudio.screens.ScreenGame;
import ru.samsung.gamestudio.screens.ScreenMenu;
import ru.samsung.gamestudio.screens.ScreenRestart;
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
    public static final int SCR_WIDTH = 1280,SCR_HEIGHT = 720;
    public OrthographicCamera camera;
    public ScreenGame screenGame;
    public ScreenRestart screenRestart;
    public ScreenMenu screenMenu;

    @Override
	public void create () {
		batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,SCR_WIDTH,SCR_HEIGHT);
        screenGame=new ScreenGame(this);
        screenRestart=new ScreenRestart(this);
        screenMenu=new ScreenMenu(this);
        setScreen(screenMenu);
		}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

