package ru.larkinds.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.larkinds.math.Rectangle;

public class Sprite extends Rectangle {

    protected float angle; //угол поворота
    protected float scale = 1f; //размер
    protected TextureRegion[] regions;
    protected int frame; //текущий кадр


    public Sprite(TextureRegion texture) {
        if (texture == null) {
            throw new NullPointerException("texture is null");
        }
        regions = new TextureRegion[1];
        regions[0] = texture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
                );
    }

    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public void resize(Rectangle worldBounds) {
    }


    public boolean touchDown(Vector2 destination, int pointer) {
        return  false;
    }

    public boolean touchUp(Vector2 destination, int pointer) {
        return false;
    }

    public void update(double deltaTime) {

    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
