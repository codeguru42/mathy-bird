package codeguru.mathybird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;

import codeguru.mathybird.MathyBirdGame;
import codeguru.mathybird.gameobjects.Bird;
import codeguru.mathybird.gameworld.GameRenderer;
import codeguru.mathybird.util.ReadyInputHandler;

public class ReadyScreen extends ScreenAdapter {
    private InputProcessor input;
    private GameRenderer renderer;
    private float runTime = 0.0f;

    public ReadyScreen(MathyBirdGame game, GameRenderer renderer, Bird bird) {
        this.input = new ReadyInputHandler(game, bird);
        this.renderer = renderer;
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        renderer.renderReady(runTime);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(input);
    }
}
