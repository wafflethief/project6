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

    private Texture texture;
    float x, y;
    float xSize, ySize;
    int width, height;
    CollisionRect rect;

    public Object(float x, float y, String imgFile, float xSize, float ySize){
        this.x = x;
        this.y = y;
        this.texture = new Texture(imgFile);
        this.xSize = xSize;
        this.ySize = ySize;
        this.rect = new CollisionRect(x, y, WIDTH, HEIGHT);
    }
    public void update(){
        this.rect.move(x, y);
    }
    public void render(SpriteBatch batch){
        batch.draw(texture, x, y, Gdx.graphics.getWidth()/xSize, Gdx.graphics.getHeight()/ySize);
    }

    public CollisionRect getCollisionRect(){
        return this.rect;
    }
}
