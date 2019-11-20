package ru.larkinds.screens;

import com.badlogic.gdx.Game;
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
import ru.larkinds.sprite.buttons.ButtonExit;
import ru.larkinds.sprite.buttons.ButtonPlay;
import ru.larkinds.sprite.stars.Star;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;

    private TextureAtlas atlas;
    private List<Star> stars;

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    private Game game;

    public MenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        stars = new ArrayList<>();
        final int STARS_COUNT = 256;
        for (int i = 0; i < STARS_COUNT; i++) {
            stars.add(new Star(atlas));
        }
        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star: stars) {
            star.resize(worldBounds);
        }
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        batch.dispose();
        bg.dispose();
        atlas.dispose();
    }

    @Override
    public boolean touchUp(Vector2 destination, int pointer) {
        buttonExit.touchUp(destination, pointer);
        buttonPlay.touchUp(destination,pointer);
        return false;
    }

    @Override
    public boolean touchDown(Vector2 destination, int pointer) {
        buttonExit.touchDown(destination, pointer);
        buttonPlay.touchDown(destination, pointer);
        return false;
    }

    private void update(float deltaTime) {
        for (Star star: stars) {
            star.update(deltaTime);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star:stars) {
            star.draw(batch);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        batch.end();
    }
}
