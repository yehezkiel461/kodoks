package com.mygdx.game.gameObjects;

import com.badlogic.gdx.math.Rectangle;


public abstract class Obstacle {
    protected Rectangle bounds;
    protected float speed;

    public Obstacle(float x, float y, float width, float height, float speed) {
        bounds = new Rectangle(x, y , width, height);
        this.speed = speed;
    }

    public abstract void update(float deltaTime);
}
