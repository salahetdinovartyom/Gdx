package ru.samsung.gamestudio.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.Locale;

public class Text {
    public static final String FONT_NAME="fonts/calibri.tff";
    public static final String RUSSIAN="АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ: ";
    public static final String ENG="ABCDEFGHIJKLMNOPQRSTUVWXYZ: ";
    private BitmapFont ruFont;
    private BitmapFont enFont;
    private BitmapFont generateFont(String characters) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters=characters;
        parameter.size=24;
        FreeTypeFontGenerator generator=new FreeTypeFontGenerator(Gdx.files.internal(Text.FONT_NAME));
        BitmapFont font=generator.generateFont(parameter);
        generator.dispose();
        return font;
    }
    public void initialize() {
        if (ruFont!=null) ruFont.dispose();
        if (enFont!=null) enFont.dispose();
        ruFont=generateFont(RUSSIAN);
        enFont=generateFont(ENG);

    }
    public BitmapFont getFont (Locale locale) {
        if ("ru".equals(locale.getLanguage())) return ruFont;
        else if ("en".equals(locale.getLanguage())) return enFont;
        else return null;
    }


}

