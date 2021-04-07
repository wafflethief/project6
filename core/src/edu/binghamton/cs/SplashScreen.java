package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Gdx.graphics;
import static com.badlogic.gdx.Gdx.input;

public class SplashScreen extends ScreenAdapter {
    private SpriteBatch batch;
    private Texture texture;
    HappyBirthday game;
    TextUI tui;
    String text;

    public SplashScreen(HappyBirthday game){
        //super();
        texture = new Texture("raw/birthday_cake.png");
        this.game = game;
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        /*Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
                    game.setScreen(new InstructionScreen(game));
                }
                return true;
            }
        });*/
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            game.setScreen(new InstructionScreen(game));
        }

        Gdx.gl.glClearColor(.25f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        text = "Welcome. Press enter to play";
        float textWidth = graphics.getWidth()/15f;
        float textHeight =  graphics.getHeight()/10f;

        tui = new TextUI("rubik/Rubik-Black.ttf");
        tui.setFields(text, 45, 0.25f, Color.WHITE, Color.CORAL, 1f, 1f, textWidth, textHeight);
        game.batch.begin();
        tui.draw(game.batch, 1f);
        game.batch.draw(texture, 200, graphics.getHeight());
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide(){
        input.setInputProcessor(null);
    }

    @Override
    public void dispose() {

    }
}
