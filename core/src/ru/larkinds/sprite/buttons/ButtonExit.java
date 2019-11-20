package ru.larkinds.sprite.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.larkinds.base.Button;
import ru.larkinds.math.Rectangle;

public class ButtonExit extends Button {

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.15f);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }

    @Override
    public void resize(Rectangle worldBounds) {
        setHeightProportion(0.15f);
        setRight(worldBounds.getRight() - 0.05f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }

}
