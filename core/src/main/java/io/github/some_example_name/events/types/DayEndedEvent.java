package io.github.some_example_name.events.types;

import io.github.some_example_name.events.GameEvent;

public class DayEndedEvent implements GameEvent {
    private int day;

    public DayEndedEvent(int day){
        this.day = day;
    }

    public int getDay(){
        return day;
    }
}
