package ru.larkinds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import javax.xml.soap.Text;

import ru.larkinds.base.BaseScreen;
import ru.larkinds.math.Rectangle;
import ru.larkinds.sprite.Background;
import ru.larkinds.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private static final float VELOCITY_LENGTH = 0.5f;
    private Texture img;
    private Texture bg;
    private Background background;
    private Logo logo;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        bg = new Texture("textures/bg.png");
        logo = new Logo(new TextureRegion(img));
        logo.setHeightProportion(0.5f);
        background = new Background(new TextureRegion(bg));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        background.draw(batch);
        logo.draw(batch);
		batch.end();
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
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
        img.dispose();
        bg.dispose();
        super.dispose();

    }



    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        destination.set(screenX, Gdx.graphics.getHeight() - screenY);
//        velocity.set(destination.sub(position));
//        velocity.set(destination.cpy().sub(position)).setLength(VELOCITY_LENGTH);
        return super.touchDown(screenX, screenY, pointer, button);

    }

    @Override
    public boolean touchDown(Vector2 destination, int pointer) {
        return false;
    }
}
