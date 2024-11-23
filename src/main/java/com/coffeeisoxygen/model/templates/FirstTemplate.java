package com.coffeeisoxygen.model.templates;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.helpers.TileHelper;
import com.coffeeisoxygen.model.interfaces.IBoardTemplate;
import com.coffeeisoxygen.model.interfaces.ITile;

public class FirstTemplate implements IBoardTemplate {

    private static final int WIDTH = 12;
    private static final int HEIGHT = 6;
    private static final String NAME = "Peta Dari Ibu Shinta";

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
                tiles[y][x] = factory.createTile(TileType.NORMALPOINTTILE, Point.of(x, y));
            }
        }
    }

    private void setSpecialTiles(ITileFactory factory, ITile[][] tiles) {
        // Danger Tiles
        int[][] dangerPoints = {
                { 2, 1 }, { 2, 2 }, { 2, 3 }, { 2, 10 },
                { 3, 5 }, { 3, 8 }, { 3, 9 }, { 3, 10 },
                { 4, 2 }, { 4, 5 }, { 4, 7 }, { 4, 8 }, { 4, 9 }, { 4, 10 },
                { 5, 5 }
        };
        TileHelper.setTileType(factory, tiles, dangerPoints, TileType.DANGERPOINTTILE);

        // Safe Tiles
        int[][] checkpointPoints = {
                { 1, 7 }, { 2, 5 }, { 3, 1 }, { 4, 6 }, { 5, 0 }
        };
        TileHelper.setTileType(factory, tiles, checkpointPoints, TileType.CHECKPOINTTILE);
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
