package ru.larkinds.sprite.stars;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.larkinds.base.Sprite;
import ru.larkinds.math.Rectangle;
import ru.larkinds.math.Rnd;

public class Star extends Sprite {

    private Vector2 velocity;
    private Rectangle worldBounds;

    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        velocity = new Vector2();
        setHeightProportion(Rnd.nextFloat(0.015f, 0.0065f));
        float vy = Rnd.nextFloat(-0.0015f, -0.002f);
        float vx = Rnd.nextFloat(-0.0001f, 0.0001f);
        velocity.set(vx, vy);
    }


    @Override
    public void resize(Rectangle worldBounds) {
       this.worldBounds = worldBounds;
       float positionX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
       float positionY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
       pos.set(positionX, positionY);
    }

    @Override
    public void update(double deltaTime) {
        pos.add(velocity);
        checkBounds();
    }

    private void checkBounds() {
        if (getRight() < worldBounds.getLeft()) {
            setLeft(worldBounds.getRight());
        }
        if (getLeft() > worldBounds.getRight()) {
            setRight(worldBounds.getLeft());
        }
        if (getTop() < worldBounds.getBottom()) {
            setBottom(worldBounds.getTop());
        }
        if (getBottom() > worldBounds.getTop()) {
            setTop(worldBounds.getBottom());
        }
    }
}
