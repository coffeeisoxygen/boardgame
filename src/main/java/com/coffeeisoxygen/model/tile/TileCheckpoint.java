package com.coffeeisoxygen.model.tile;

import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.IPoint;

public class TileCheckpoint extends Tile {

    public TileCheckpoint(IPoint position) {
        super(Tile.tileTypeColorMap.get(TileType.CHECKPOINTTILE), "C", position, TileType.CHECKPOINTTILE);
    }

    @Override
    public void onPlayerStep(IPlayer player) {
        // TODO : Comeback later with a cup of cofee and implement this method

    }

}
