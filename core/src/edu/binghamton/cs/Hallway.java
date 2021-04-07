package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Hallway extends ScreenAdapter {
    HappyBirthday game;
    TextUI tui;
    ShapeRenderer shapeRenderer;
    ArrayList<Object> objects;
    CollisionRect rect;
    Texture texture;

    float shapeX;
    float shapeY;
    Object player;

    public Hallway(HappyBirthday game){
        this.game = game;
        texture = new Texture("raw/blue_white_tile.jpg");

        this.shapeRenderer = game.shapeRenderer;
        this.shapeX = 200;
        this.shapeY = 100;
        player = new Object(shapeX, shapeY, "raw/dog_monopoly.png", 10f, 20f, "it's you");

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
                    //shapeX = Gdx.input.getX();
                    //shapeY = Gdx.graphics.getHeight() - Gdx.input.getY();
                    player.x = Gdx.input.getX();
                    player.y = Gdx.graphics.getHeight() - Gdx.input.getY();
                    player.update();
                }
                if(keyCode == Input.Keys.UP){
                    //shapeY += 15;
                    player.y += 20;
                    player.update();
                }
                if(keyCode == Input.Keys.DOWN){
                    //shapeY -= 15;
                    player.y -= 20;
                    player.update();
                }
                if(keyCode == Input.Keys.RIGHT){
                    //shapeX += 20;
                    player.x += 20;
                    player.update();
                }
                if(keyCode == Input.Keys.LEFT){
                    //shapeX -= 20;
                    player.x -= 20;
                    player.update();
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(153f/255f, 204f/255f, 255f/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        objects.add(new Object(0f, 0f, "raw/apollo-sculpture.png", 12f,20f, "a statue of apollo"));
        objects.add(new Object(770f, 1700f, "raw/statue-classical.png", 4f, 6f, "another statue"));
        //objects.add(new Object(10f, 10f, "raw/chair.png"));

        game.batch.begin();
        //player = new Object(shapeX, shapeY, "raw/dog_monopoly.png", 10f, 20f, "it's you");
        game.batch.draw(texture, 0, 0);
        player.render(game.batch);

        for (Object o : objects){
            o.render(game.batch);
        }
        for (Object o : objects){
            if(o.getCollisionRect().collidesWith(player.getCollisionRect())){
                //o.remove();
                /*String text = o.description;
                float textWidth = graphics.getWidth()/15f;
                float textHeight =  graphics.getHeight()/1.05f;
                tui.setFields(text, 40, 0.25f, Color.WHITE, Color.CORAL, 1f, 1f, textWidth, textHeight);
                tui.draw(game.batch, 1f);*/
            }
            /*else{
                o.render(game.batch);
            }*/
        }
        String text = objects.get(0).getDescription();
        float textWidth = graphics.getWidth()/15f;
        float textHeight =  graphics.getHeight()/1.05f;
        tui.setFields(text, 40, 0.25f, Color.WHITE, Color.CORAL, 1f, 1f, textWidth, textHeight);
        tui.draw(game.batch, 1f);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
