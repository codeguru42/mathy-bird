package codeguru.mathybird.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import codeguru.mathybird.util.AssetLoader;

public class Grass extends Scrollable {
    public Grass(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }

    @Override
    public void render(SpriteBatch batch, float runTime) {
        batch.draw(AssetLoader.grass, getX(), getY());
    }
}
