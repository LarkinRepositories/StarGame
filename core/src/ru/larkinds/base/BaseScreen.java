package ru.larkinds.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;


import ru.larkinds.math.MatrixUtils;
import ru.larkinds.math.Rectangle;

public class BaseScreen implements Screen, InputProcessor {

    protected SpriteBatch batch;

    private Rectangle screenBounds;
    private Rectangle worldBounds;
    private Rectangle glBounds;

    private Matrix4 worldToGl;
    private Matrix3 screenToWorld;

    private Vector2 destination;

    public BaseScreen() {
        this.screenBounds = new Rectangle();
        this.worldBounds = new Rectangle();
        this.glBounds = new Rectangle(0,0,1f,1f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        this.destination = new Vector2();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        this.batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize width = " + width + "height = " + height);
        screenBounds.setSize(width, height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);

        float aspect = width / (float) height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f * aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
        batch.setProjectionMatrix(worldToGl);
        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        resize(worldBounds);
    }

    public void resize(Rectangle worldBounds){

    }

    @Override
    public void pause() {
        System.out.println("pause");
    }

    @Override
    public void resume() {
        System.out.println("resume");
    }

    @Override
    public void hide() {
        System.out.println("hide");
        dispose();
    }


    @Override
    public void dispose () {
        System.out.println("dispose");
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
        destination.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDown(destination, pointer);
        return false;
    }

    public boolean touchDown(Vector2 destination, int pointer) {
        System.out.println("touchDown destinationX = "+destination.x + "destinationY = " +destination.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        //System.out.printf("touchUp event, screenX = %s, screenY = %s, pointer = %s, button = %s", screenX, screenY, pointer, button);
        return false;
    }


    public boolean touchUp(Vector2 destination, int pointer) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //System.out.printf("touchDragged event, screenX = %s, screenY = %s, pointer = %s, button = %s", screenX, screenY, pointer);
        destination.set(screenX, screenBounds.getHeight() - screenY).mul(screenToWorld);
        touchDragged(destination, pointer);
        return false;
    }

    public boolean touchDragged(Vector2 destination, int pointer) {
        System.out.println("touchDragged destinationX = "+destination.x + "destinationY = "+destination.y);
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
