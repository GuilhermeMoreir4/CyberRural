package io.github.some_example_name.collision;

import io.github.some_example_name.events.GameEvent;

public class CollisionEvent implements GameEvent {
    private Object entityA;
    private Object entityB;

    public CollisionEvent(Object entityA, Object entityB){
        this.entityA = entityA;
        this.entityB = entityB;
    }

    public Object getEntityA() {
        return entityA;
    }

    public Object getEntityB() {
        return entityB;
    }
}
