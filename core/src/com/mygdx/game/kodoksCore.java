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
	Kodoks player = new Kodoks();

	float grid = 50; //size kodok

	gameSound gs = new gameSound();

	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundTexture = new Texture("background.png");
		gs.GameSound();
		gs.playGameMusic();
		//sistem Skin
		player.createBatch();
		player.resetPosition();
		player.update(batch);




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
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)
				|| Gdx.input.isKeyJustPressed(Input.Keys.A) ){
			player.move(player.getBounds(),-1, 0);
//			player.update(batch);
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)
				|| Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			player.move(player.getBounds(),1, 0);
//			player.update(batch);
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)
				|| Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			player.move(player.getBounds(), 0,-1);
//			player.update(batch);
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)
				|| Gdx.input.isKeyJustPressed(Input.Keys.W)){
			player.move(player.getBounds(),0,1);
//			player.update(batch);
			gs.playJumpSound();
		}
		player.update(batch);
		if (player.getBounds().x > 400){
			player.getBounds().x = 400;
		}
		if (player.getBounds().x < 0){
			player.getBounds().x = 0;
		}
		if (player.getBounds().y > 850){
			player.getBounds().y = 850;
		}
		if (player.getBounds().y < 0){
			player.getBounds().y = 0;
		}

	}

	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundTexture.dispose();
		gs.disposeSound();
		player.disposeFrog();

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
		font.draw(batch, "Game Paused", 100, 400);
		font.draw(batch, "Press esc to resume", 70, 370);
		batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
			resume();
		}
	}
}
