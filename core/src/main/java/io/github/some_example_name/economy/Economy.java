package io.github.some_example_name.economy;

import com.badlogic.gdx.math.MathUtils;
import io.github.some_example_name.GameConfig;
import io.github.some_example_name.events.EventBus;
import io.github.some_example_name.events.types.DayEndedEvent;
import io.github.some_example_name.interfaces.BasicBehavior;

public class Economy implements BasicBehavior {

    private float money;
    private float taxRate;


    public Economy(EventBus eventBus){
        money = GameConfig.INITIAL_MONEY;
        taxRate = GameConfig.INITIAL_TAX_RATE;
        eventBus.subscribe(DayEndedEvent.class, this::tax);
    }

    public void earn(float value){
        money += value;
        taxRate = Math.min(GameConfig.MINIMAL_GROWING_TAX_RATE,taxRate + value * GameConfig.GROWING_TAX_RATE);
    }

    @Override
    public void update(float delta) {

    }

    public void tax(DayEndedEvent event){
        money -= taxRate;
        System.out.println(
            "[DAY " + event.getDay() + "] Tax applied. Money = " + money
        );
    }

    public void setNewTax(float newTax){
        taxRate = MathUtils.clamp(newTax, GameConfig.MINIMAL_GROWING_TAX_RATE, GameConfig.MAXIMAL_GROWING_TAX_RATE);
    }

    public float getMoney() {
        return money;
    }

}
