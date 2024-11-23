package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.interfaces.ITile;

public class Board {

    private int width;
    private int height;
    private ITile[][] tiles;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ITile[][] getTiles() {
        return tiles;
    }

    public void setTiles(ITile[][] tiles) {
        this.tiles = tiles;
    }

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

}
