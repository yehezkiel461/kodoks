package com.mygdx.game.gameData;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class gameSound {
    public Sound jumpSound;
    public Sound hitSound;
    public Music gameMusic;

    public void GameSound() {
        jumpSound = Gdx.audio.newSound(Gdx.files.internal("jumpSound.mp3"));
        hitSound = Gdx.audio.newSound(Gdx.files.internal("hitSound.wav"));
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("GameMusic.mp3"));
    }

    public void playJumpSound() {
        jumpSound.play();
    }

    public void playHitSound() {
        hitSound.play();
    }

    public void playGameMusic() {
        gameMusic.play();
        gameMusic.setLooping(true);
    }

    public void stopGameMusic() {
        gameMusic.stop();
    }

    public void disposeSound() {
        jumpSound.dispose();
        hitSound.dispose();
        gameMusic.dispose();
    }
}
