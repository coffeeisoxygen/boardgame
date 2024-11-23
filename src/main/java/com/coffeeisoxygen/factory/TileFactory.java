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

    @Override
    public ITile createTile(TileType type, IPoint position) {
        return switch (type) {
            case STARTPOINTTILE -> new TileStartpoint(position);
            case FINISHPOINTTILE -> new TileFinishpoint(position);
            case CHECKPOINTTILE -> new TileCheckpoint(position);
            case DANGERPOINTTILE -> new TileDangerpoint(position);
            case NORMALPOINTTILE -> new TileNormalpoint(position);
            default -> new TileNormalpoint(position);
        };
    }
}