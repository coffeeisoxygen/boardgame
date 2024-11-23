package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.interfaces.ITile;

public class Board {
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

    // Getter untuk akses atribut Board
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ITile getTile(int x, int y) {
        return tiles[y][x];
    }

    public String getName() {
        return name;
    }

    public ITile[][] getTiles() {
        return tiles;
    }
}
