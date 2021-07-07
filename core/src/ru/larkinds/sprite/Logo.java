package ru.larkinds.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.larkinds.base.Sprite;

public class Logo extends Sprite implements Controlable {

    private static final float VELOCITY_LENGTH = 0.005f;

    private Vector2 velocity = null;
    private Vector2 endPoint = null;
    private Vector2 buffer = null;

    public Logo(TextureRegion texture) {
        super(texture);
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
//        if (Gdx.input.isKeyPressed(19) && Gdx.graphics.getHeight() > pos.y + this.getHeight()) {
//            pos.add(0,1);
//        }
//        if (Gdx.input.isKeyPressed(20) && pos.y > 0) {
//            pos.add(0,-1);
//        }
//        if (Gdx.input.isKeyPressed(21) && pos.x > 0) {
//            pos.add(-1,0);
//        }
//        if (Gdx.input.isKeyPressed(22) && Gdx.graphics.getWidth() > pos.x + this.getWidth()) {
//            pos.add(1,0);
//        }
    }

    @Override
    public boolean touchDown(Vector2 destination, int pointer) {
        endPoint.set(destination);
        velocity.set(destination.cpy().sub(pos)).setLength(VELOCITY_LENGTH);
        return false;
    }

    @Override
    public void update(double deltaTime) {
        controlWithMouse();
        controlWithKeyBoard();
    }
}
