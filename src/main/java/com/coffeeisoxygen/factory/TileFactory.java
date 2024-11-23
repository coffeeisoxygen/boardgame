package com.coffeeisoxygen.factory;

import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.interfaces.IPoint;
import com.coffeeisoxygen.model.interfaces.ITile;
import com.coffeeisoxygen.model.tile.TileCheckpoint;
import com.coffeeisoxygen.model.tile.TileDangerpoint;
import com.coffeeisoxygen.model.tile.TileFinishpoint;
import com.coffeeisoxygen.model.tile.TileNormalpoint;
import com.coffeeisoxygen.model.tile.TileStartpoint;

public class TileFactory implements ITileFactory {
    // Singleton instance
    private static final TileFactory instance = new TileFactory();

    // Private constructor
    private TileFactory() { }

    // Get Singleton instance
    public static TileFactory getInstance() {
        return instance;
    }

    @Override
    public ITile createTile(TileType type, IPoint position) {
        switch (type) {
            case NORMALPOINTTILE:
                return new TileNormalpoint(position);
            case DANGERPOINTTILE:
                return new TileDangerpoint(position);
            case CHECKPOINTTILE:
                return new TileCheckpoint(position);
            case STARTPOINTTILE:
                return new TileStartpoint(position);
            case FINISHPOINTTILE:
                return new TileFinishpoint(position);
            default:
                throw new IllegalArgumentException("Unknown TileType: " + type);
        }
    }
}
