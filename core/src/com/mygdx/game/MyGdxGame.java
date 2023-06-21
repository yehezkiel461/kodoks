package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture backgroundTexture;
	Texture frogTexture;

	private BitmapFont font;
	private boolean paused;

	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundTexture = new Texture("");
		frogTexture = new Texture("");
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		if (paused){
			drawPauseMenu();
			return;
		}

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			pause();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public void pause(){
		paused = true;
	}
	@Override
	public void resume(){
		paused = false;
	}

	void drawPauseMenu(){
		batch.begin();
		batch.draw(backgroundTexture, 0, 0);
		//batch.draw(frogTexture, frog.x, frog.y);
		font.draw(batch, "Game Paused", 100, 400);
		font.draw(batch, "Press esc to resume", 70, 370);
		batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			resume();
		}
	}
}
