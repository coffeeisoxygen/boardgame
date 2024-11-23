package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.ITile;

public class Board implements IBoard {
    private int width;
    private int height;
    private ITile[][] tiles;
    private String name;

    // Constructor hanya bisa dipanggil dari Builder
    Board(BoardBuilder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.tiles = builder.tiles;
        this.name = builder.name;
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
    public ITile getTile(int x, int y) {
        return tiles[y][x];
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITile[][] getAllTiles() {
        return tiles;
    }

    public void resize(int newWidth, int newHeight, ITileFactory factory) {
        ITile[][] newTiles = new ITile[newHeight][newWidth];
        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                if (y < height && x < width) {
                    newTiles[y][x] = tiles[y][x];
                } else {
                    newTiles[y][x] = factory.createTile(TileType.NORMALPOINTTILE, Point.of(x, y));
                }
            }
        }
        this.width = newWidth;
        this.height = newHeight;
        this.tiles = newTiles;
    }

    public void clearTiles(ITileFactory factory) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = factory.createTile(TileType.NORMALPOINTTILE, Point.of(x, y));
            }
        }
    }
}
