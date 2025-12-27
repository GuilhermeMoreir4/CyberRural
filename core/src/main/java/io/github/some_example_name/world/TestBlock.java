package io.github.some_example_name.world;

import com.badlogic.gdx.math.Rectangle;
import io.github.some_example_name.GameConfig;
import io.github.some_example_name.collision.Collidable;
import io.github.some_example_name.collision.CollisionEvent;
import io.github.some_example_name.events.EventBus;

public class TestBlock implements Collidable {
    private Rectangle bounds;

    public TestBlock(float xPosition, float yPosition, EventBus eventBus){
        bounds = new Rectangle();
        bounds.x = xPosition;
        bounds.y = yPosition;
        bounds.width = GameConfig.CELL_SIZE;
        bounds.height = GameConfig.CELL_SIZE;
        eventBus.subscribe(CollisionEvent.class, this::onCollision);
    }

    private void onCollision(CollisionEvent event){
        System.out.println("Object colliding: " + event.getEntityA().toString() + " AND " + event.getEntityB().toString());
    }

    @Override
    public Rectangle getBounds() {
        return bounds;
    }

    @Override
    public String getName() {
        return "Block";
    }


}
