package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.interfaces.ITile;

public class FirstTemplate implements IBoardTemplate {

    private static final int WIDTH = 12;
    private static final int HEIGHT = 6;
    private static final String NAME = "Peta Dari Ibu Shinta";

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

        // first row
        tiles[0][1] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 1));
        tiles[0][2] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 2));
        tiles[0][3] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 3));
        tiles[0][0] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 4));
        tiles[0][5] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 5));
        tiles[0][6] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 6));
        tiles[0][7] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 7));
        tiles[0][8] = factory.createTile(TileType.DANGERPOINTTILE, new Point(0, 8));
        // second row
        tiles[1][1] = factory.createTile(TileType.DANGERPOINTTILE, new Point(1, 1));
        tiles[1][5] = factory.createTile(TileType.DANGERPOINTTILE, new Point(1, 5));
        tiles[1][6] = factory.createTile(TileType.DANGERPOINTTILE, new Point(1, 6));
        tiles[1][8] = factory.createTile(TileType.DANGERPOINTTILE, new Point(1, 8));
        tiles[1][10] = factory.createTile(TileType.DANGERPOINTTILE, new Point(1, 10));
        // third row
        tiles[2][1] = factory.createTile(TileType.DANGERPOINTTILE, new Point(2, 1));
        tiles[2][2] = factory.createTile(TileType.DANGERPOINTTILE, new Point(2, 2));
        tiles[2][3] = factory.createTile(TileType.DANGERPOINTTILE, new Point(2, 3));
        tiles[2][10] = factory.createTile(TileType.DANGERPOINTTILE, new Point(2, 10));
        // fourth row
        tiles[3][5] = factory.createTile(TileType.DANGERPOINTTILE, new Point(3, 5));
        tiles[3][8] = factory.createTile(TileType.DANGERPOINTTILE, new Point(3, 8));
        tiles[3][9] = factory.createTile(TileType.DANGERPOINTTILE, new Point(3, 9));
        tiles[3][10] = factory.createTile(TileType.DANGERPOINTTILE, new Point(3, 10));
        // fifth row
        tiles[4][2] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 2));
        tiles[4][5] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 5));
        tiles[4][7] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 7));
        tiles[4][8] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 8));
        tiles[4][9] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 9));
        tiles[4][10] = factory.createTile(TileType.DANGERPOINTTILE, new Point(4, 10));
        // sixth row
        tiles[5][5] = factory.createTile(TileType.DANGERPOINTTILE, new Point(5, 5));

        // second row
        tiles[1][7] = factory.createTile(TileType.CHECKPOINTTILE, new Point(1, 7));
        // third row
        tiles[2][5] = factory.createTile(TileType.CHECKPOINTTILE, new Point(2, 5));
        // fourth row
        tiles[3][1] = factory.createTile(TileType.CHECKPOINTTILE, new Point(3, 1));
        // fifth row
        tiles[4][6] = factory.createTile(TileType.CHECKPOINTTILE, new Point(4, 6));
        // sixth row
        tiles[5][0] = factory.createTile(TileType.CHECKPOINTTILE, new Point(5, 0));
        tiles[5][1] = factory.createTile(TileType.CHECKPOINTTILE, new Point(5, 1));

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
