package ru.larkinds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

import ru.larkinds.base.BaseScreen;
import ru.larkinds.math.Rectangle;
import ru.larkinds.sprite.background.Background;
import ru.larkinds.sprite.spaceships.SpaceShip;
import ru.larkinds.sprite.stars.Star;

public class GameScreen extends BaseScreen {

    private Texture bg;
    private Background background;

    private TextureAtlas atlas;
    private List<Star> stars;

    private SpaceShip spaceShip;

    @Override
    public void show() {
        super.show(); bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        final int STARS_COUNT = 128;
        stars = new ArrayList<>();
        for (int i = 0; i < STARS_COUNT; i++) {
            stars.add(new Star(atlas));
        }
        spaceShip = new SpaceShip(atlas, "main_ship");
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
        super.render(delta);
    }

    @Override
    public void resize(Rectangle worldBounds) {
        background.resize(worldBounds);
        for (Star star:stars) {
            star.resize(worldBounds);
        }
        spaceShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 destination, int pointer) {
        spaceShip.touchDown(destination, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 destination, int pointer) {
        return super.touchUp(destination, pointer);
    }

    private void update(float deltaTime) {
        for (Star star:stars) {
            star.update(deltaTime);
        }
        spaceShip.update(deltaTime);
    }

    private void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star: stars) {
            star.draw(batch);
        }
        spaceShip.draw(batch);
        batch.end();
    }
}
