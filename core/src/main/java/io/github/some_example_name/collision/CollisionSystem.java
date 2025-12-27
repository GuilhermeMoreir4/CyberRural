package io.github.some_example_name.collision;

import io.github.some_example_name.events.EventBus;

import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class CollisionSystem {
    ;
    private final EventBus eventBus;

    private final List<Collidable> collidables;

    public CollisionSystem(EventBus eventBus){
        this.eventBus = eventBus;
        this.collidables = new ArrayList<>();
    }

    public void addCollidable(Collidable collidable){
        collidables.add(collidable);
    }

    public void removeCollidable(Collidable collidable){
        collidables.remove(collidable);
    }


    public void update(){
        for (int i = 0; i < collidables.size(); i++){
            for (int j = i + 1; j < collidables.size(); j++){
                Collidable a = collidables.get(i);
                Collidable b = collidables.get(j);

                if(a.getBounds().overlaps(b.getBounds())){
                    eventBus.publish(new CollisionEvent(a,b));
                }

            }
        }
    }
}
