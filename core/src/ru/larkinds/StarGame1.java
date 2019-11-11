package ru.larkinds;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class StarGame1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion region;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		img = new Texture("Background/space_eye-wallpaper-2048x2048.jpg");
		//region = new TextureRegion(img, 1000, 1000, 1024, 1024	);
		Vector2 v1 = new Vector2(3f,5f);
		Vector2 v2 = new Vector2(6f,8f);
		v1.add(v2); //cложение векторов
		System.out.println("v1.add(v2) | v1.x ="+v1.x+" v1.y="+v1.y);
		Vector2 v3 = v1.cpy().add(v2);
		System.out.println("v1.cpy().add(v2) | v3.x="+v3.x+"v3.y="+v3.y);
		v1.set(5,4); //явная установка значения вектора
		v2.set(2,2);
		v1.sub(v2); //вычитание векторов
		v1.len(); //получаем длину вектора по теореме пифагора
		System.out.println(v1.len());
		v1.len2(); //получаем квадрат длины вектора (квадрат гипотенузы)
		v1.scl(0,9f); //умножаем вектор на скаляр - кратно увеличиваем или уменьшаем
		System.out.println(v1.len());
		v1.nor(); //нормализация векторов
		v1.dot(v2); //умножение векторов друг на друга
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0, 2048, 2048);
		//batch.draw(region, 50 , 50 , 1024, 1024);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
