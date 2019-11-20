package ru.larkinds.sprite.spaceships;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.larkinds.base.Ship;
import ru.larkinds.math.Rectangle;
import ru.larkinds.sprite.Controlable;

public class SpaceShip extends Ship implements Controlable {

    private static final float VELOCITY_LENGTH = 0.005f;

    private Vector2 velocity;
    private Vector2 endPoint;
    private Vector2 buffer;



    public SpaceShip(TextureAtlas atlas, String regionName) {
        super(atlas, regionName);
        velocity = new Vector2();
        endPoint = new Vector2();
        buffer = new Vector2();
    }

    @Override
    public void controlWithMouse() {
        buffer.set(endPoint);
        if ((buffer.sub(pos)).len() > VELOCITY_LENGTH) {
            pos.add(velocity);
        } else {
            pos.set(endPoint);
        }
    }

    @Override
    public void controlWithKeyBoard() {

    }

    @Override
    public boolean touchDown(Vector2 destination, int pointer) {
        endPoint.set(destination);
        velocity.set(destination.cpy().sub(pos)).setLength(VELOCITY_LENGTH);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 destination, int pointer) {
        return super.touchUp(destination, pointer);
    }

    @Override
    public void update(double deltaTime) {
        controlWithMouse();
    }

    @Override
    public void resize(Rectangle worldBounds) {
        setHeightProportion(0.19f);
        setRight(worldBounds.getRight() - 0.25f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }
}
