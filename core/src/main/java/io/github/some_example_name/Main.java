package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.some_example_name.collision.CollisionSystem;
import io.github.some_example_name.economy.Economy;
import io.github.some_example_name.events.EventBus;
import io.github.some_example_name.time.GameTime;
import io.github.some_example_name.world.Player;
import io.github.some_example_name.world.TestBlock;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private Player player;
    private GameTime time;
    private Economy economy;


    private BitmapFont bitMapFont;
    private SpriteBatch spriteBatch;

    private TestBlock block;

    private CollisionSystem collisionSystem;

    private EventBus eventBus;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        player = new Player(50,60);

        eventBus =  new EventBus();
        time = new GameTime(eventBus);
        economy = new Economy(eventBus);
        bitMapFont = new BitmapFont();
        spriteBatch = new SpriteBatch();

        block = new TestBlock(70,70, eventBus);

        collisionSystem = new CollisionSystem(eventBus);

        collisionSystem.addCollidable(player);
        collisionSystem.addCollidable(block);
    }

    private void renderInfos(){
        spriteBatch.begin();
        bitMapFont.draw(spriteBatch, "Money $ " + String.format("%.2f",economy.getMoney()), 10, 460);
        bitMapFont.draw(spriteBatch,"Day progress" + String.format("%.0f%%",time.getDayProgess() * 100), 10,440);
        bitMapFont.draw(spriteBatch,"Day" + time.getDay(), 10,420);
        spriteBatch.end();
    }

    private void renderPlayer(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(player.getBounds().x, player.getBounds().y,24,24 );
        shapeRenderer.end();
    }

    private void renderBlock(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(block.getBounds().x, block.getBounds().y, 24, 24);
        shapeRenderer.end();
    }

    private void update(float deltaTime){
        collisionSystem.update();
        player.update(deltaTime);
        time.update(deltaTime);
        economy.update(deltaTime);
    }

    private void draw(){
        ScreenUtils.clear(0.05f, 0.05f, 0.08f, 1);
        renderPlayer();
        renderBlock();
        renderInfos();
    }


    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        update(deltaTime);
        draw();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        bitMapFont.dispose();
        spriteBatch.dispose();
    }

}
