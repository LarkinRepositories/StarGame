package ru.larkinds.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Button extends Sprite  {

    private int pointer;
    private boolean isPressed;

    public Button(TextureRegion texture) {
        super(texture);
    }

    @Override
    public boolean touchDown(Vector2 destination, int pointer) {
        if (isPressed || !isMe(destination)) {
          return false;
        }
        isPressed = true;
        scale = 0.9f;
        this.pointer = pointer;
        return false;
    }

    @Override
    public boolean touchUp(Vector2 destination, int pointer) {
        if (this.pointer != pointer || !isPressed) {
            return false;
        }
        if (isMe(destination)) {
            action();
        }
        isPressed = false;
        scale = 1.0f;
        return false;
    }

    public abstract void action();

}
