package ru.larkinds.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.larkinds.base.BaseScreen;

public class MenuScreen extends BaseScreen {
    private Texture img;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 destination;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        position = new Vector2();
        velocity = new Vector2();
        destination = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0, 2048, 2048);
        batch.draw(img, position.x,position.y);
		//batch.draw(region, 50 , 50 , 1024, 1024);
		batch.end();
        controlWithKeyBoard();
        controlWithMouse();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
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
        super.dispose();

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        destination.set(screenX, Gdx.graphics.getHeight() - screenY);
        velocity.set(destination.sub(position));
        return super.touchDown(screenX, screenY, pointer, button);

    }

    private void controlWithKeyBoard() {
        if (Gdx.input.isKeyPressed(19) && Gdx.graphics.getHeight() > position.y + img.getHeight()) {
            position.add(0,1);
        }
        if (Gdx.input.isKeyPressed(20) && position.y > 0) {
            position.add(0,-1);
        }
        if (Gdx.input.isKeyPressed(21) && position.x > 0) {
            position.add(-1,0);
        }
        if (Gdx.input.isKeyPressed(22) && Gdx.graphics.getWidth() > position.x + img.getWidth()) {
            position.add(1,0);
        }
    }

    private void controlWithMouse() {
        if ((Gdx.graphics.getHeight() > destination.y + img.getHeight()
                || Gdx.graphics.getHeight() > position.y - img.getHeight() && position.y > 0)
                || (Gdx.graphics.getWidth() > destination.x + img.getWidth()
                || Gdx.graphics.getWidth() > position.x - img.getWidth()) && position.x > 0) {
            position.add(velocity.x/60, velocity.y/60);
        }
//        if (position.x + img.getWidth() < destination.x + img.getWidth() || position.y + img.getHeight() < destination.y + img.getHeight()) {
//            position.add(velocity.x/60, velocity.y/60);
//        }
    }
}
