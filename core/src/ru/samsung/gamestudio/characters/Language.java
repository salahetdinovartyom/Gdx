package ru.samsung.gamestudio.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.Locale;

public class Language {
    public static String restart,menu,record,count,start,exit,terms;
public static void setLanguage (boolean isEng){
    if (isEng) {
        restart="Restart";
        menu="Menu";
        record="Record: ";
        count="Count: ";
        start="Start";
        exit="Exit";
        terms="Terms of use";
    } else {
        restart="Заново";
        menu="Меню";
        record="Рекорд: ";
        count="Счёт: ";
        start="Старт";
        exit="Выйти";
        terms="Условия исп.";
    }
}
//    public void setLanguage(boolean isEng) {
//        this.isEng=isEng;
//    }
}
