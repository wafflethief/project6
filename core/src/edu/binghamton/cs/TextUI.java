package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TextUI extends Actor {
    BitmapFont font;
    String text;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public TextUI(String text){
        this.font = new BitmapFont();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("rubik/Rubik-Black.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35;
        parameter.borderWidth = 0.5f;
        parameter.borderColor = Color.WHITE;
        parameter.color = Color.CHARTREUSE;
        this.font = generator.generateFont(parameter);
        generator.dispose();
        this.text = text;
        this.font.getData().setScale(0.4f, 0.4f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        font.draw(batch, text, Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight());
    }
}
