package ru.larkinds.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseScreen implements Screen, InputProcessor {

    protected SpriteBatch batch;


    @Override
    public void show() {
        this.batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }


    @Override
    public void dispose () {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("KeyDown event, keycode: "+keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("KeyUp event, keycode: "+keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("KeyDown event, character: "+character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //System.out.printf("touchDown event, screenX = %s, screenY = %s, pointer = %s, button = %s", screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //System.out.printf("touchUp event, screenX = %s, screenY = %s, pointer = %s, button = %s", screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //System.out.printf("touchDragged event, screenX = %s, screenY = %s, pointer = %s, button = %s", screenX, screenY, pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println("Scrolled, amount = "+amount);
        return false;
    }
}
