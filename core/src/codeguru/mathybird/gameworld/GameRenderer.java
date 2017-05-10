package codeguru.mathybird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import codeguru.mathybird.gameobjects.Bird;
import codeguru.mathybird.gameobjects.ScrollHandler;
import codeguru.mathybird.util.AssetLoader;

public class GameRenderer {
    private static final float WORLD_WIDTH = 136.0f;
    public static final float WORLD_HEIGHT = 204.0f;
    public static final float GROUND_WIDTH = WORLD_WIDTH;
    public static final float GROUND_HEIGHT = 26.0f;
    private static final int SCORE_POSITION_FROM_TOP = 11;

    private final GameWorld world;
    private final ShapeRenderer shapeRenderer = new ShapeRenderer();
    private SpriteBatch batch = new SpriteBatch();
    private Bird bird;
    private ScrollHandler scroller;

    public GameRenderer(GameWorld world) {
        OrthographicCamera cam = new OrthographicCamera();
        cam.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);

        this.world = world;
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer.setProjectionMatrix(cam.combined);

        initGameObjects();
    }

    private void initGameObjects() {
        bird = world.getBird();
        scroller = world.getScroller();
    }

    public void renderReady(float runTime) {
        render(runTime);
    }

    public void renderGame(float runTime) {
        render(runTime);
        renderScore();
    }

    private void render(float runTime) {
        Gdx.gl.glClearColor(0x81 / 255.0f, 0xD2 / 255.0f, 0xE7 / 255.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw Dirt
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(147.0f / 255.0f, 80.0f / 255.0f, 27.0f / 255.0f, 1.0f);
        shapeRenderer.rect(0.0f, 0.0f, GROUND_WIDTH, GROUND_HEIGHT);
        shapeRenderer.end();

        batch.begin();
        batch.draw(AssetLoader.bg, 0.0f, GROUND_HEIGHT);
        scroller.render(batch, runTime);
        bird.render(batch, runTime);
        batch.end();
    }

    private void renderScore() {
        String score = world.getScore() + "";
        batch.begin();
        AssetLoader.shadow.draw(batch, score,
                (136 / 2) - (3 * score.length()), WORLD_HEIGHT - SCORE_POSITION_FROM_TOP - 1);
        AssetLoader.font.draw(batch, "" + score,
                (136 / 2) - (3 * score.length() - 1), WORLD_HEIGHT - SCORE_POSITION_FROM_TOP);
        batch.end();
    }
}
