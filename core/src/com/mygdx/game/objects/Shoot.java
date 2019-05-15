package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Assets;

public class Shoot {
    enum State {
        SHOOTING, TO_REMOVE
    }

    Vector2 position;

    float stateTime;
    State state;
    float speed = 5;

    TextureRegion frame;

    Shoot(float position){
        this.position = new Vector2(position, 16);
        state = State.SHOOTING;
    }

    void render(SpriteBatch batch){
        batch.draw(frame, position.x, position.y);
    }

    public void update(float delta, Assets assets) {
        stateTime += delta;

        position.y += speed;

        frame = assets.shoot.getKeyFrame(stateTime, true);
    }

    public void remove(){
        state = State.TO_REMOVE;
    }
}
