package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.gameObjects.*;
import com.mygdx.game.gameData.gameSound;

public class kodoksCore extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture backgroundTexture;

	private BitmapFont font;
	private boolean paused;

	Kodoks player = new Kodoks(250, 900, 50, 50);

	float grid = 50; //size kodok

	gameSound gs = new gameSound();

	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundTexture = new Texture("background.png");
		gs.GameSound();
		gs.playGameMusic();
		//sistem Skin
//		player.createBatch();





	}

	@Override
	public void render () {
		if (paused) {
			drawPauseMenu();
			return;
		}

		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(backgroundTexture, 0, 0);

		batch.end();

		//pause keys
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			pause();
		}

		//movement keys
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)
				|| Gdx.input.isKeyPressed(Input.Keys.A) ){
			player.move(-1, 0);
			player.update();
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)
				|| Gdx.input.isKeyPressed(Input.Keys.D)) {
			player.move(1, 0);
			player.update();
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)
				|| Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.move(0, 1);
			player.update();
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)
				|| Gdx.input.isKeyPressed(Input.Keys.W)){
			player.move(0,1);
			player.update();
			gs.playJumpSound();
		}

	}

	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundTexture.dispose();
		gs.disposeSound();
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
//		batch.draw(backgroundTexture, 0, 0);
		font.draw(batch, "Game Paused", 100, 400);
		font.draw(batch, "Press esc to resume", 70, 370);
		batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			resume();
		}
	}
}
