package com.coffeeisoxygen.model.board;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.TileFactory;
import com.coffeeisoxygen.model.interfaces.ITile;

public class BoardBuilder {
    // Default values
    int width = 10;
    int height = 10;
    ITile[][] tiles;
    String name = "Default Board";

    // Set ukuran board
    public BoardBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this; // Fluent API
    }

    // Set nama board
    public BoardBuilder setName(String name) {
        this.name = name;
        return this;
    }

    // Set tiles custom (optional)
    public BoardBuilder setTiles(ITile[][] customTiles) {
        this.tiles = customTiles;
        return this;
    }

    // Generate default tiles jika tiles belum di-set
    private void generateDefaultTiles(TileFactory factory) {
        this.tiles = new ITile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.tiles[y][x] = factory.createTile(TileType.NORMALPOINTTILE, new Point(x, y));
            }
        }
    }

    // Build Board
    public Board build(TileFactory factory) {
        if (tiles == null) {
            generateDefaultTiles(factory); // Buat default tiles
        }
        return new Board(this); // Pass ke Board
    }
}

