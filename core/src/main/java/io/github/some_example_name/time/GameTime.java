package io.github.some_example_name.time;

import io.github.some_example_name.GameConfig;
import io.github.some_example_name.Main;
import io.github.some_example_name.events.EventBus;
import io.github.some_example_name.events.types.DayEndedEvent;
import io.github.some_example_name.interfaces.BasicBehavior;

public class GameTime implements BasicBehavior {
    private float time;

    private int day;

    private EventBus eventBus;

    public GameTime(EventBus eventBus){
        this.eventBus = eventBus;
        this.day = 1;
    }

    @Override
    public void update(float delta){
        time += delta;
        if (time >= GameConfig.DAY_DURATION){
            time = 0;
            day++;
            eventBus.publish(new DayEndedEvent(day));
        }
    }

    public float getDayProgess(){
        return time / GameConfig.DAY_DURATION;
    }

    public int getDay() {
        return day;
    }
}
