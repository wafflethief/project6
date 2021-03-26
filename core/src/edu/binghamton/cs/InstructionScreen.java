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

public class InstructionScreen extends ScreenAdapter {
    HappyBirthday game;
    BitmapFont bmFont;
    String text;
    ShapeRenderer border;


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
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        gl.glClearColor(0, 0,0,1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //game.rainSound.play();

        game.batch.begin();
        //game.font.getData().scale(.1f); //.scale causes zooming in...
        game.font.getData().setScale(3.5f);
        //game.font.getData().fontFile(Gdx.files.internal("fonts/black.ttf"));
        game.font.draw(game.batch, "I - Instructions\n" +
                "B - Ballroom\n"+
                "L - Library(coming soon)\n", graphics.getWidth()/8, graphics.getHeight()/1.08f);
        game.batch.end();
        border.begin(ShapeRenderer.ShapeType.Line);
        border.setColor(Color.WHITE);
        border.rect(graphics.getWidth()/40, graphics.getHeight()/50, 1010,1000);
        border.end();
    }
    @Override
    public void hide(){
        input.setInputProcessor(null);
    }
}
