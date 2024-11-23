package com.coffeeisoxygen.model.tile;

import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.IPoint;

public class TileNormalpoint extends Tile {

    public TileNormalpoint(IPoint position) {
        super(Tile.tileTypeColorMap.get(TileType.STARTPOINTTILE), "N", position, TileType.STARTPOINTTILE);
    }

    @Override
    public void onPlayerStep(IPlayer player) {
        // TODO : Comeback later with a cup of cofee and implement this method

    }

}
