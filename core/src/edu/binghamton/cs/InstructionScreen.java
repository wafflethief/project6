package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class InstructionScreen extends ScreenAdapter {
    HappyBirthday game;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont bmFont;
    String text;

    public InstructionScreen(HappyBirthday game){
        this.game = game;
        /*this.generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/turtle.ttf"));
        this.parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        this.bmFont = generator.generateFont(parameter);
        this.text = "Welcome to my home";*/
    }
    
    @Override
    public void show(){

        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keyCode){
                if(keyCode == Input.Keys.SPACE){
                    game.setScreen(new Ballroom(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(.25f, 0,.25f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        //bmFont.draw(game.batch, text, 10, 10);
        //game.font.getData().scale(.01f); //CAUSES WEIRD BEHAVIOR
        game.font.draw(game.batch, "Instructions", Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/5);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
