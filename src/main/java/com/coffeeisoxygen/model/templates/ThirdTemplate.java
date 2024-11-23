package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.interfaces.ITile;

public class ThirdTemplate implements IBoardTemplate {

    private static final int WIDTH = 3;
    private static final int HEIGHT = 10;
    private static final String NAME = "Peta Sample 3";

    @Override
    public ITile[][] generateTemplate(ITileFactory factory) {
        ITile[][] tiles = new ITile[HEIGHT][WIDTH];

        // Helper untuk set tile
        setDefaultTiles(factory, tiles);
        setSpecialTiles(factory, tiles);

        return tiles;
    }

    private void setDefaultTiles(ITileFactory factory, ITile[][] tiles) {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                tiles[y][x] = factory.createTile(TileType.NORMALPOINTTILE, new Point(x, y));
            }
        }
    }

    private void setSpecialTiles(ITileFactory factory, ITile[][] tiles) {
        // Start & Finish
        tiles[0][0] = factory.createTile(TileType.STARTPOINTTILE, new Point(0, 0));
        tiles[HEIGHT - 1][WIDTH - 1] = factory.createTile(TileType.FINISHPOINTTILE, new Point(WIDTH - 1, HEIGHT - 1));

        // Danger Tiles
        int[][] dangerPoints = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 0, 6 } };
        setTileType(factory, tiles, dangerPoints, TileType.DANGERPOINTTILE);

        // Safe Tiles
        int[][] checkpointPoints = { { 2, 3 }, { 2, 4 } };
        setTileType(factory, tiles, checkpointPoints, TileType.CHECKPOINTTILE);
    }

    private void setTileType(ITileFactory factory, ITile[][] tiles, int[][] points, TileType type) {
        for (int[] point : points) {
            int x = point[1];
            int y = point[0];
            tiles[y][x] = factory.createTile(type, new Point(x, y));
        }
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
