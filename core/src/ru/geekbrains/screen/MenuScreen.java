package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch;
    private Vector2 speed;
    private Vector2 pos;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        speed = new Vector2();
        pos = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if ((int)Math.floor(pos.len()) != (int)Math.floor(touch.len())
//                (int)Math.floor(pos.x) != (int)Math.floor(touch.x) &&
//                (int)Math.floor(pos.x) != (int)Math.floor(touch.x)
        ) {
            pos.add(speed.nor());
        }
//        else {
//            pos.x = touch.x;
//            pos.y = touch.y;
//        }
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
//        System.out.println(pos);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        System.out.println("touch.x = " + touch.x + " touch.y = " + touch.y);
        System.out.println("touch -----"+touch);
        speed = touch.cpy().sub(pos);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        int right = 22;
        int left = 21;
        int up = 19;
        int down = 22;

        if (keycode == right){ pos.add(1,0); }
        if (keycode == left){ pos.add(-1,0); }
        if (keycode == up){ pos.add(0,1); }
        if (keycode == down){ pos.add(0,-1); }

        return super.keyDown(keycode);
    }
}
