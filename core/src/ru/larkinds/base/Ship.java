package ru.larkinds.base;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.larkinds.base.Sprite;


public abstract class Ship extends Sprite {

    private boolean isPlayer;
    private int hitpoints;
    private int baseDamage;



    public Ship(TextureAtlas atlas, String regionName) {
        super(atlas.findRegion(regionName));
    }


}
