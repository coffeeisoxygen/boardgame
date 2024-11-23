package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.interfaces.ITile;

public class SecondTemplate implements IBoardTemplate {

    private static final int WIDTH = 12;
    private static final int HEIGHT = 6;
    private static final String NAME = "Peta Template Kedua";

    @Override
    public ITile[][] generateTemplate(ITileFactory factory) {
        ITile[][] tiles = new ITile[HEIGHT][WIDTH];

        // Generate base tiles
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                TileType type = TileType.NORMALPOINTTILE; // Default tile
                tiles[y][x] = factory.createTile(type, new Point(x, y));
            }
        }

        // Set Start Point
        tiles[0][0] = factory.createTile(TileType.STARTPOINTTILE, new Point(0, 0));

        // Set Finish Point
        tiles[HEIGHT - 1][WIDTH - 1] = factory.createTile(TileType.FINISHPOINTTILE, new Point(WIDTH - 1, HEIGHT - 1));

        // Add Danger Tiles
        tiles[0][1] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 3));
        tiles[0][2] = factory.createTile(TileType.DANGERPOINTTILE, new Point(5, 5));
        tiles[0][3] = factory.createTile(TileType.DANGERPOINTTILE, new Point(2, 6));
        tiles[0][4] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 3));
        tiles[0][5] = factory.createTile(TileType.DANGERPOINTTILE, new Point(5, 5));
        tiles[0][6] = factory.createTile(TileType.DANGERPOINTTILE, new Point(2, 6));

        // Add Safe Tiles
        tiles[2][3] = factory.createTile(TileType.CHECKPOINTTILE, new Point(3, 2));
        tiles[7][7] = factory.createTile(TileType.CHECKPOINTTILE, new Point(7, 7));

        return tiles;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
