package ru.larkinds;

import com.badlogic.gdx.Game;

import ru.larkinds.screens.MenuScreen;

public class StarGame extends Game {


	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
