package com.mygdx.game.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Log extends Obstacle{
    public Texture log;
    public Array<Rectangle> logMoves;
    private long lastSpawnTime = 0;

    public Log(){

    }

    public Log(float x, float y, float width, float height, float speed) {
        super(x, y, width, height, speed);
    }

    public void createLog(){
        log = new Texture("obstacles/log.png");
        logMoves = new Array<>();
    }

    @Override
    public void update(float deltaTime) {

    }

    public void show(SpriteBatch batch){
        batch.begin();
        for (Rectangle logmove : logMoves) {
            batch.draw(log, logmove.x, logmove.y);
        }
        batch.end();
    }

    @Override
    public void spawn() {
        Rectangle log = new Rectangle();
        log.x = 440;
        log.y = 300;
        log.setHeight(50);
        log.setWidth(148);
        logMoves.add(log);
        lastSpawnTime = TimeUtils.nanoTime() + 3000000000L;

        Rectangle log2 = new Rectangle();
        log2.x = 440;
        log2.y = 250;
        log2.setHeight(50);
        log2.setWidth(148);
        logMoves.add(log2);
        lastSpawnTime = TimeUtils.nanoTime() + 3000000000L;

        Rectangle log3 = new Rectangle();
        log3.x = 440;
        log3.y = 190;
        log3.setHeight(50);
        log3.setWidth(148);
        logMoves.add(log3);
        lastSpawnTime = TimeUtils.nanoTime() + 3400000000L;

        Rectangle log4 = new Rectangle();
        log4.x = 440;
        log4.y = 130;
        log4.setHeight(50);
        log4.setWidth(148);
        logMoves.add(log4);
        lastSpawnTime = TimeUtils.nanoTime() + 3800000000L;

        Rectangle log5 = new Rectangle();
        log5.x = 440;
        log5.y = 70;
        log5.setHeight(50);
        log5.setWidth(148);
        logMoves.add(log5);
        lastSpawnTime = TimeUtils.nanoTime() + 5000000000L;
    }

    public void disposeLog(){
        log.dispose();
    }

}
