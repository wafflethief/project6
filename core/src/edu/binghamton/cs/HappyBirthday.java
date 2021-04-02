package edu.binghamton.cs;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
//import com.sun.xml.internal.ws.api.model.wsdl.WSDLDescriptorKind;

import java.awt.TextField;

public class HappyBirthday extends Game {//extends ApplicationAdapter {
	private static long SPLASH_MINIMUM_MILLIS = 2000L;

	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	AssetManager manager;
	MyTextInputListener listener;
	TextField textField;
	Music rainSound;
	ShapeRenderer shapeRenderer;

	String text;
	FreeTypeFontGenerator generator;
	FreeTypeFontGenerator.FreeTypeFontParameter parameter;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font = new BitmapFont();
		/*
		generator = new FreeTypeFontGenerator(Gdx.files.internal("rubik/Rubik-Black.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 35;
		parameter.borderWidth = 0.5f;
		parameter.borderColor = Color.WHITE;
		parameter.color = Color.CHARTREUSE;
		this.font = generator.generateFont(parameter);
		generator.dispose();
		this.text = text;
		this.font.getData().setScale(0.4f, 0.4f);
		*/
		manager = new AssetManager();
		shapeRenderer = new ShapeRenderer();

		rainSound = Gdx.audio.newMusic(Gdx.files.internal("raw/zapsplat_rain.mp3"));
		rainSound.setLooping(true);

		setScreen(new InstructionScreen(HappyBirthday.this));
	}

	@Override
	public void dispose () {
		getScreen().dispose();
		shapeRenderer.dispose();
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}