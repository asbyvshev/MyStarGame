package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 0.5f;

    private Texture img;
    private Vector2 touch;
    private Vector2 speed;
    private Vector2 pos;
    private Vector2 buf;

    private Vector2 vRight;
    private Vector2 vLeft;
    private Vector2 vUp;
    private Vector2 vDown;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        speed = new Vector2();
        pos = new Vector2();
        buf = new Vector2();
        vRight = new Vector2(1,0);
        vLeft = new Vector2(-1,0);
        vUp = new Vector2(0,1);
        vDown = new Vector2(0,-1);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        buf.set(touch);
        if (buf.sub(pos).len() > V_LEN) {
            pos.add(speed);
        } else {
            pos.set(touch);
        }
        Gdx.gl.glClearColor(0.26f, 0.5f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
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
        speed.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        int right = 22;
        int left = 21;
        int up = 19;
        int down = 20;

        if (keycode == right){ pos.add(vRight); }
        if (keycode == left){ pos.add(vLeft); }
        if (keycode == up){ pos.add(vUp); }
        if (keycode == down){ pos.add(vDown); }

        return false;
    }
}
