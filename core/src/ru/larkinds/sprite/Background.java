package ru.larkinds.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.larkinds.base.Sprite;
import ru.larkinds.math.Rectangle;

public class Background extends Sprite {
    public Background(TextureRegion texture) {
        super(texture);
        setHeightProportion(1f);
    }

    @Override
    public void resize(Rectangle worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(1f);
        this.pos.set(worldBounds.pos);
    }
}
