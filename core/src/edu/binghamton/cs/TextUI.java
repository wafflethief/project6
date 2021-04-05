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
    float posX;
    float posY;

    public TextUI(String fontFile){
        this.font = new BitmapFont();
        generator = new FreeTypeFontGenerator(Gdx.files.internal(fontFile));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    }

    public void setFields(String text, int size, float borderWidth, Color borderColor,
                          Color color, float scaleX, float scaleY, float posX, float posY){
        this.text = text;
        this.parameter.size = size;
        this.parameter.borderWidth = borderWidth;
        this.parameter.borderColor = borderColor;
        this.parameter.color = color;
        this.font = this.generator.generateFont(parameter); // move to constructor?
        this.generator.dispose();
        this.font.getData().setScale(scaleX, scaleY);
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        font.draw(batch, text, this.posX, this.posY);
    }
}
