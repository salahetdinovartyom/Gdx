package ru.samsung.gamestudio;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Locale;
import ru.samsung.gamestudio.characters.Language;
import ru.samsung.gamestudio.components.Text;
import ru.samsung.gamestudio.screens.ScreenGame;
import ru.samsung.gamestudio.screens.ScreenMenu;
import ru.samsung.gamestudio.screens.ScreenRestart;


public class MyGdxGame extends Game {
	public SpriteBatch batch;
    public static final int SCR_WIDTH = 1280,SCR_HEIGHT = 720;
    public OrthographicCamera camera;
    public ScreenGame screenGame;
    public ScreenRestart screenRestart;
    public ScreenMenu screenMenu;
    public final Locale ruLocale=new Locale("ru","RU");
    Text text;

    @Override
	public void create () {
		batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,SCR_WIDTH,SCR_HEIGHT);
        screenGame=new ScreenGame(this);
        screenRestart=new ScreenRestart(this);
        screenMenu=new ScreenMenu(this);
        text = new Text();
        text.initialize();
        Language.setLanguage(true);
        setScreen(screenMenu);

		}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

