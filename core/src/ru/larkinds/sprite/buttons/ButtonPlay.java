package ru.larkinds.sprite.buttons;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.larkinds.base.Button;
import ru.larkinds.math.Rectangle;
import ru.larkinds.screens.GameScreen;

public class ButtonPlay extends Button {

    private Game game;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        this.game = game;
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }

    @Override
    public void resize(Rectangle worldBounds) {
        setHeightProportion(0.19f);
        setLeft(worldBounds.getLeft() + 0.05f);
        setBottom(worldBounds.getBottom() + 0.05f);
    }
}
