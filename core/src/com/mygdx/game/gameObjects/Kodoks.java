package com.mygdx.game.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class Kodoks {
    public boolean isIntersect = false;


    private Rectangle bounds;

    Texture kodokOriginal;
    Texture kodokSkin1;
    Texture kodokSkin2;


    public Kodoks(){
        bounds = new Rectangle(250, 250 , 50, 50);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void cekCollision(Rectangle otherObject){
        if (bounds.overlaps(otherObject)){
            isIntersect = true;
            resetPosition();
        } else {
            isIntersect = false;
        }
    }

    public void resetPosition(){
        bounds.setPosition(220,850);
    }

    public void move(Rectangle bounds, float xdir, float ydir){
        bounds.x +=  xdir*50;
        bounds.y += ydir*50;
    }

    public void createBatch(){
        kodokSkin1 = new Texture("frog/blackSolo.png");
    }

    public void update(SpriteBatch batch){
        batch.begin();
        batch.draw(kodokSkin1, bounds.x, bounds.y);
        batch.end();
    }

    public void disposeFrog(){
        kodokSkin1.dispose();
    }
}
