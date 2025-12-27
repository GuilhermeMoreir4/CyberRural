package io.github.some_example_name.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import io.github.some_example_name.GameConfig;
import io.github.some_example_name.collision.Collidable;
import io.github.some_example_name.interfaces.BasicBehavior;

public class Player implements BasicBehavior, Collidable {
    private Rectangle bounds;
    private float speed = GameConfig.PLAYER_VELOCITY;

    public Player(float xPosition, float yPosition){
        bounds = new Rectangle();

        bounds.setX(xPosition);
        bounds.setY(yPosition);

        bounds.width = GameConfig.CELL_SIZE;
        bounds.height = GameConfig.CELL_SIZE;
    }


    @Override
     public void update(float delta){
         float distanceToMove = speed * delta;

         if(Gdx.input.isKeyPressed(Input.Keys.A)) bounds.x -= distanceToMove;
         if(Gdx.input.isKeyPressed(Input.Keys.D)) bounds.x += distanceToMove;

         if(Gdx.input.isKeyPressed(Input.Keys.S)) bounds.y -= distanceToMove;
         if(Gdx.input.isKeyPressed(Input.Keys.W)) bounds.y += distanceToMove;
     }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public String getName() {
        return "Player";
    }
}
