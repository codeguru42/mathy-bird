package codeguru.zombiebird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameRenderer {
    private final OrthographicCamera cam;
    private final GameWorld myWorld;

    public GameRenderer(GameWorld world) {
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);

        myWorld = world;
    }

    public void render() {
        Gdx.app.log("GameRenderer", "render");
    }
}
