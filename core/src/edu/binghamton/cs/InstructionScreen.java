package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

import java.awt.Shape;

import static com.badlogic.gdx.Gdx.*;
import static com.badlogic.gdx.Gdx.graphics;

public class InstructionScreen extends ScreenAdapter {
    HappyBirthday game;
    BitmapFont bmFont;
    String text;
    ShapeRenderer border;
    TextUI tui;


    public InstructionScreen(HappyBirthday game){
        this.game = game;
        border = new ShapeRenderer();
    }
    
    @Override
    public void show(){
        input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.B){
                    game.setScreen(new Ballroom(game));
                }
                if(keyCode == Input.Keys.H){
                    game.setScreen(new Hallway(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        gl.glClearColor(0, 0,0,1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //game.rainSound.play();

        // TODO: move all the screen text to text files and read in...
        // B will take you to a ballroom
        //
        text = "\nCommands: \n" +
                "B - Ballroom\n" +
                "L - Library(todo)";
        float textWidth = graphics.getWidth()/15f;
        float textHeight =  graphics.getHeight()/1.05f;
        tui = new TextUI( "rubik/Rubik-Black.ttf");
        tui.setFields(text, 40, 0.25f, Color.WHITE, Color.CORAL, 1f, 1f, textWidth, textHeight);

        game.batch.begin();
        tui.draw(game.batch, 1f);
        game.batch.end();

        // draw border
        border.begin(ShapeRenderer.ShapeType.Line);
        border.setColor(Color.CORAL);
        border.rect(graphics.getWidth()/40f, graphics.getHeight()/50f, 1010,2000);
        border.end();
    }
    @Override
    public void hide(){
        input.setInputProcessor(null);
    }
}
