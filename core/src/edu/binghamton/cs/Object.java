package edu.binghamton.cs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// any item in the room...
public class Object {
    public static final int WIDTH = 3;
    public static final int HEIGHT = 4;

    private static Texture texture;
    float x, y;
    int width, height;
    CollisionRect rect;
    Sprite sprite;

    public Object(float x, float y, String imgFile){
        this.x = x;
        this.y = y;
        texture = new Texture(imgFile);
        this.rect = new CollisionRect(x, y, WIDTH, HEIGHT);
        //sprite = new Sprite(new Texture(imgFile));
    }
    public void update(){
        this.rect.move(x, y);
    }
    public void render(SpriteBatch batch){
        /*sprite.setScale(.2f);
        sprite.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sprite.draw(batch);*/

        batch.draw(texture, x, y, Gdx.graphics.getWidth()/3f, Gdx.graphics.getHeight()/5f);
    }

    public CollisionRect getCollisionRect(){
        return this.rect;
    }
}
