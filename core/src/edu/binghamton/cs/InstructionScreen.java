package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class InstructionScreen extends ScreenAdapter {
    HappyBirthday game;

    public InstructionScreen(HappyBirthday game){
        this.game = game;
    }
    
    @Override
    public void show(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/turtle.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
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

        game.font.draw(game.batch, "Instructions", Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/2);
        game.batch.end();
    }

}
