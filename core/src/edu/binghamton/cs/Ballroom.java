package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Ballroom extends ScreenAdapter {
    HappyBirthday game;
    TextUI tui;
    ShapeRenderer shapeRenderer;
    ArrayList<Object> objects;

    float shapeX;
    float shapeY;
    Object player;

    public Ballroom(HappyBirthday game){
        this.game = game;
        this.shapeRenderer = game.shapeRenderer;
        this.shapeX = 200;
        this.shapeY = 100;
        player = new Object(shapeX, shapeY, "raw/dog_monopoly.png", 10f, 20f);

        objects = new ArrayList<Object>();

    }

    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.I) {
                    game.setScreen(new InstructionScreen(game));
                }
                if(Gdx.input.isTouched()){
                    shapeX = Gdx.input.getX();
                    shapeY = Gdx.graphics.getHeight() - Gdx.input.getY();
                }
                if(keyCode == Input.Keys.UP){
                    shapeY += 15;
                }
                if(keyCode == Input.Keys.DOWN){
                    shapeY -= 15;
                }
                if(keyCode == Input.Keys.RIGHT){
                    shapeX += 15;
                }
                if(keyCode == Input.Keys.LEFT){
                    shapeX -= 15;
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(153f/255f, 204f/255f, 255f/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /*
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.circle(shapeX, shapeY, 50);
        shapeRenderer.end();*/

        objects.add(new Object(800f, 1700f, "raw/lemon.png", 12f,20f));
        objects.add(new Object(770f, 1700f, "raw/piano.png", 4f, 6f));
        //objects.add(new Object(10f, 10f, "raw/chair.png"));

        game.batch.begin();
        player.render(game.batch);

        for (Object o : objects){
            o.render(game.batch);
        }
        for (Object o : objects){
            if(o.getCollisionRect().collidesWith(player.getCollisionRect())){
                o.remove();
            }
        }
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
