package io.github.some_example_name.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.some_example_name.GameConfig;
import io.github.some_example_name.Main;
import io.github.some_example_name.interfaces.BasicBehavior;

public class Player implements BasicBehavior {
    private float x;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float y;
     private float speed = GameConfig.PLAYER_VELOCITY;

     public Player(float xPosition, float yPosition){
         this.x = xPosition;
         this.y = yPosition;
     }


    @Override
     public void update(float delta){
         float distanceToMove = speed * delta;

         if(Gdx.input.isKeyPressed(Input.Keys.A)) x -= distanceToMove;
         if(Gdx.input.isKeyPressed(Input.Keys.D)) x += distanceToMove;
         if(Gdx.input.isKeyPressed(Input.Keys.S)) y -= distanceToMove;
         if(Gdx.input.isKeyPressed(Input.Keys.W)) y += distanceToMove;
     }

}
