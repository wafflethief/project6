package edu.binghamton.cs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
//import com.sun.xml.internal.ws.api.model.wsdl.WSDLDescriptorKind;

import java.awt.TextField;

public class HappyBirthday extends Game {//extends ApplicationAdapter {
	private static long SPLASH_MINIMUM_MILLIS = 2000L;

	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	ShapeRenderer shapeRenderer;
	AssetManager manager;
	MyTextInputListener listener;
	TextField textField;
	Music rainSound;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		shapeRenderer = new ShapeRenderer();
		manager = new AssetManager();
		rainSound = Gdx.audio.newMusic(Gdx.files.internal("raw/zapsplat_rain.mp3"));
		rainSound.setLooping(true);

		setScreen(new InstructionScreen(HappyBirthday.this));
	}

	/*@Override
	public void render () {
		if(manager.update()){}
		float progress = manager.getProgress();
		manager.finishLoading();

		Gdx.gl.glClearColor(204.0f/255.0f, 255.0f/255.0f, 152.0f/255.0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0);
		font.getData().setScale(5);
		font.draw(batch, "Happy Birthday!", Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/2);
		batch.end();

		Gdx.input.setInputProcessor(new InputAdapter(){
			@Override
			public boolean keyDown(int keyCode){
				if(keyCode == Input.Keys.SPACE){
					HappyBirthday.this.setScreen(new Ballroom(HappyBirthday.this));
				}
				return true;
			}
		});
	}*/

	@Override
	public void dispose () {
		getScreen().dispose();
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}