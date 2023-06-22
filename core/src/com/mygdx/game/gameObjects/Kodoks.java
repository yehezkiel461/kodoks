package com.mygdx.game.gameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class Kodoks extends Rectangle {
    public boolean isIntersect = false;

    
    private Rectangle bounds;
    float grid = 50; // size kodok
    Texture kodokOriginal;
    Texture kodokSkin1;
    Texture kodokSkin2;

    public Kodoks(float x, float y, float width, float height){
        bounds = new Rectangle(x, y , width, height);
    }

    public void createBatch(){
        kodokOriginal = new Texture("");
        kodokSkin1 = new Texture("blackSolo");
        kodokSkin2 = new Texture("");
    }

    public void cekCollision(Rectangle otherObject){
        if (bounds.overlaps(otherObject)){
            isIntersect = true;
            resetPosition(bounds);
        } else {
            isIntersect = false;
        }
    }

    public void resetPosition(Rectangle kodoksPos){
        kodoksPos.set(250,900, 50,50);
    }

    public void move(float xdir, float ydir){
        x +=  xdir * grid;
        y -= ydir * grid;
    }

    public void update(SpriteBatch batch, float x, float y){
        batch.begin();
        batch.draw(kodokSkin1, x, y);
        batch.end();
    }
}
