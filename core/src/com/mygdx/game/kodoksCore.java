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

import java.util.Iterator;

public class kodoksCore extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture backgroundTexture;

	private BitmapFont font;
	private boolean paused;
	private boolean isOnLog;
	Kodoks player = new Kodoks();
	Log log = new Log();

	gameSound gs = new gameSound();


	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundTexture = new Texture("background.png");
		gs.GameSound();
		gs.playGameMusic();
		//kodk
		player.createBatch();
		player.resetPosition();
		player.update(batch);

		//log
		log.createLog();



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



		//log
		log.spawn();
		Iterator<Rectangle> iter = log.logMoves.iterator();
		while (iter.hasNext()) {
			Rectangle logmove = iter.next();
			logmove.x -= 50 * Gdx.graphics.getDeltaTime();
			if (logmove.x + 127 < 0) {
				iter.remove();
			}
			if (logmove.overlaps(player.getBounds()) && player.getBounds().y < logmove.y + logmove.height) {
				player.getBounds().x -= 50 * Gdx.graphics.getDeltaTime();
				isOnLog = true; // Mengatur status isOnLog menjadi true
			} else {
				isOnLog = false; // Mengatur status isOnLog menjadi false jika kodok tidak berada di atas log
			}
		}
		log.show(batch);
		//pause keys
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			pause();
		}

		//movement keys
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)
				|| Gdx.input.isKeyJustPressed(Input.Keys.A) ){
			player.move(player.getBounds(),-1, 0);
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)
				|| Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			player.move(player.getBounds(),1, 0);
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)
				|| Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			player.move(player.getBounds(), 0,-1);
			gs.playJumpSound();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)
				|| Gdx.input.isKeyJustPressed(Input.Keys.W)){
			player.move(player.getBounds(),0,1);
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
		log.disposeLog();
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
