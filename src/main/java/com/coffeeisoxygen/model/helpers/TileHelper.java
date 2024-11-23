package com.coffeeisoxygen.model.helpers;

import com.coffeeisoxygen.model.classes.Point;
import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.factory.ITileFactory;
import com.coffeeisoxygen.model.interfaces.ITile;

public class TileHelper {

    // Method to set a single type of tile
    public static void setTileType(ITileFactory factory, ITile[][] tiles, int[][] points, TileType type) {
        for (int[] point : points) {
            int x = point[1];
            int y = point[0];
            tiles[y][x] = factory.createTile(type, Point.of(x, y));
        }
    }

    // Method to set multiple types of tiles
    public static void setMultipleTileTypes(ITileFactory factory, ITile[][] tiles, int[][] points, TileType[] types) {
        if (points.length != types.length) {
            throw new IllegalArgumentException("Points and types arrays must have the same length");
        }
        for (int i = 0; i < points.length; i++) {
            int x = points[i][1];
            int y = points[i][0];
            tiles[y][x] = factory.createTile(types[i], Point.of(x, y));
        }
    }

    // Method to set tiles with a custom strategy
    public static void setTilesWithStrategy(ITileFactory factory, ITile[][] tiles, int[][] points,
            TileCreationStrategy strategy) {
        for (int[] point : points) {
            int x = point[1];
            int y = point[0];
            TileType type = strategy.determineTileType(x, y);
            tiles[y][x] = factory.createTile(type, Point.of(x, y));
        }
    }

    // Interface for custom tile creation strategy
    public interface TileCreationStrategy {
        TileType determineTileType(int x, int y);
    }
}