package io.github.some_example_name.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventBus {

    private final Map<Class<?extends GameEvent>, List<Consumer<? extends GameEvent>>> listeners = new HashMap();


    public <T extends GameEvent> void subscribe(
        Class<T> eventType,
        Consumer<T> handler
    ){
        listeners
            .computeIfAbsent(eventType, k -> new ArrayList<>())
            .add(handler);
    }

    @SuppressWarnings("unchecked")
    public <T extends GameEvent> void publish(T event){
        List<Consumer< ? extends GameEvent>> handlers = listeners.get(event.getClass());

        for(Consumer<? extends GameEvent> handler : handlers){
            ((Consumer<T>) handler).accept(event);
        }

    }
}
