package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.interfaces.ITile;

public class DefaultTemplate implements IBoardTemplate {

    private final int width;
    private final int height;
    private final String name;

    public DefaultTemplate(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    @Override
    public ITile[][] generateTemplate(ITileFactory factory) {
        ITile[][] tiles = new ITile[height][width];

        // Set all tiles to normal type
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = factory.createTile(TileType.NORMALPOINTTILE, Point.of(x, y));
            }
        }

        // Set start points at the edges
        tiles[0][0] = factory.createTile(TileType.STARTPOINTTILE, Point.of(0, 0));
        tiles[height - 1][width - 1] = factory.createTile(TileType.STARTPOINTTILE, Point.of(width - 1, height - 1));

        return tiles;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public String getName() {
        return name;
    }
}