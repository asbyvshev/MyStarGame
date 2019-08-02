package ru.geekbrains.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.lang.reflect.Field;

import ru.geekbrains.base.ScaledTouchUpButton;
import ru.geekbrains.math.Rect;
import ru.geekbrains.screen.GameScreen;

public class ButtonNewGame extends ScaledTouchUpButton {
//    private enum State {PLAYING, PAUSE, GAME_OVER}
//    private GameScreen gameScreen;
    private Game game;

    public ButtonNewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
//        this.gameScreen = gameScreen;
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.1f);
        setBottom(worldBounds.getBottom() + 0.5f);
//        setRight(worldBounds.getRight() - 0.5f);
    }

//    @Override
//    public void action(){ /*game.setScreen(new GameScreen(game));*/
////        Class gs = GameScreen.class;
////        try {
////            Field f = gs.getDeclaredField("state");
////            f.setAccessible(true);
////            f.set(gameScreen, State.PLAYING);
////        } catch (NoSuchFieldException e) {
////            e.printStackTrace();
////        } catch (IllegalAccessException e) {
////            e.printStackTrace();
////        }
//        System.out.println("сработало нажите на кнопку новая игра");
//    }

    @Override
    public void action() {
        game.setScreen(new GameScreen(game));
        System.out.println("сработало нажите на кнопку новая игра");
    }
}