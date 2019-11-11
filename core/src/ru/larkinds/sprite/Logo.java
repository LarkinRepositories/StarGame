package ru.larkinds.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.larkinds.base.Sprite;

public class Logo extends Sprite implements Controlable {

    public Logo(TextureRegion texture) {
        super(texture);
    }

    @Override
    public void controlWithMouse() {

    }

    @Override
    public void controlWithKeyBoard() {
        if (Gdx.input.isKeyPressed(19)) {

        }
    }
}
