package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.interfaces.IBoard;
import com.coffeeisoxygen.model.interfaces.ITile;

public class Board implements IBoard {
    private final int width;
    private final int height;
    private final ITile[][] tiles;
    private final String name;

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
}
