package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class Ballroom extends ScreenAdapter {
    HappyBirthday game;
    TextUI tui;
    ShapeRenderer shapeRenderer;
    ArrayList<Object> objects;
    CollisionRect rect;
    //String text;

    float shapeX;
    float shapeY;
    Object player;

    public Ballroom(HappyBirthday game){
        this.game = game;
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
                else if(keyCode == Input.Keys.DOWN){
                    //shapeY -= 15;
                    player.y -= 20;
                    player.update();
                }
                else if(keyCode == Input.Keys.RIGHT){
                    //shapeX += 20;
                    player.x += 20;
                    player.update();
                }
                else if(keyCode == Input.Keys.LEFT){
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
        /*
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.circle(shapeX, shapeY, 50);
        shapeRenderer.end();*/

        objects.add(new Object(800f, 1700f, "raw/lemon.png", 12f,20f, "a lemon"));
        objects.add(new Object(770f, 1700f, "raw/piano.png", 4f, 6f, "a piano"));
        //objects.add(new Object(10f, 10f, "raw/chair.png"));

        float textWidth = graphics.getWidth()/15f;
        float textHeight =  graphics.getHeight()/10f;
        tui = new TextUI("rubik/Rubik-Black.ttf");

        String text = "meeee";
        tui.setFields(text, 40, 0.25f, Color.WHITE, Color.CORAL, 1f, 1f, textWidth, textHeight);

        game.batch.begin();
        //player = new Object(shapeX, shapeY, "raw/dog_monopoly.png", 10f, 20f, "it's you");
        tui.draw(game.batch, 1f);
        player.render(game.batch);

        for (Object o : objects){
            o.render(game.batch);
        }
        for (Object o : objects){
            if(o.getCollisionRect().collidesWith(player.getCollisionRect())){
                tui.setFields(o.getDescription(), 45, 0.25f, Color.WHITE, Color.CORAL, 1f, 1f, textWidth, textHeight);
                tui.draw(game.batch,1f);
            }
        }
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
