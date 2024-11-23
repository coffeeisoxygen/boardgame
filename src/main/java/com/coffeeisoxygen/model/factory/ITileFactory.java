package com.coffeeisoxygen.model.factory;

import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.interfaces.IPoint;
import com.coffeeisoxygen.model.interfaces.ITile;

public interface ITileFactory {
    ITile createTile(TileType type, IPoint position);
}