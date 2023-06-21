package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private boolean paused;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		paused = false;
	}

	void drawPauseMenu(){
		batch.begin();
		batch.draw(backgroundTexture, 0, 0);
		batch.draw(frogTexture, frog.x, frog.y);
		font.draw(batch, "Game Paused", 100, 400);
		font.draw(batch, "Press esc to resume", 70, 370);
		batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE){
			resume();
		}
	}

	@Override
	public void pause(){
		paused = true;
	}
	@Override
	public void resume(){
		paused = false;
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
}
