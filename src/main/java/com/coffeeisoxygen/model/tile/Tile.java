package com.coffeeisoxygen.model.tile;

import java.awt.Color;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

import com.coffeeisoxygen.model.enumerate.TileType;
import com.coffeeisoxygen.model.interfaces.IPlayer;
import com.coffeeisoxygen.model.interfaces.IPoint;
import com.coffeeisoxygen.model.interfaces.ITile;

/**
 * The Tile class represents an abstract base class for different types of tiles
 * in a board game. It implements the ITile interface and provides common
 * properties
 * and methods for all tile types.
 * 
 * Each tile has a name, type, position, and color. The color of the tile can be
 * mapped based on its type using a static map. Subclasses of Tile must
 * implement
 * the performAction method to define specific behaviors.
 * 
 * @version 2.0
 * @since 2024-11-23
 */
public abstract class Tile implements ITile {

    /**
     * Abstract method to be implemented by subclasses to define specific behaviors.
     * This method will be called to perform the action associated with the tile.
     */
    public abstract void onPlayerStep(IPlayer player);

    private String name;
    private TileType type;
    private IPoint position;
    private Color color;

    // Map tile type to a color
    protected static final Map<TileType, Color> tileTypeColorMap;

    static {
        tileTypeColorMap = new EnumMap<>(TileType.class);
        tileTypeColorMap.put(TileType.STARTPOINTTILE, Color.GREEN);
        tileTypeColorMap.put(TileType.FINISHPOINTTILE, Color.RED);
        tileTypeColorMap.put(TileType.NORMALPOINTTILE, Color.WHITE);
        tileTypeColorMap.put(TileType.DANGERPOINTTILE, Color.BLACK);
        tileTypeColorMap.put(TileType.CHECKPOINTTILE, Color.YELLOW);
    }

    /**
     * Constructs a Tile with the specified color, name, position, and type.
     * 
     * @param color    the color of the tile
     * @param name     the name of the tile
     * @param position the position of the tile on the board
     * @param type     the type of the tile
     */
    protected Tile(Color color, String name, IPoint position, TileType type) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        this.name = name != null ? name : "Tile";
        this.position = position;
        this.type = type != null ? type : TileType.NORMALPOINTTILE;
        this.color = color != null ? color : tileTypeColorMap.get(this.type);
    }

    // Getters

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TileType getType() {
        return type;
    }

    @Override
    public IPoint getPosition() {
        return position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    // Setters

    @Override
    public void setName(String name) {
        this.name = name != null ? name : "Tile";
    }

    @Override
    public void setType(TileType type) {
        this.type = type != null ? type : TileType.NORMALPOINTTILE;
        this.color = tileTypeColorMap.get(this.type); // Update color based on type
    }

    @Override
    public void setPosition(IPoint position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        this.position = position;
    }

    @Override
    public void setColor(Color color) {
        this.color = color != null ? color : tileTypeColorMap.get(this.type);
    }

    @Override
    public String toString() {
        return String.format("Tile{name='%s', type=%s, position=%s, color=%s}",
                name, type, position, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tile tile = (Tile) o;
        return name.equals(tile.name) &&
                type == tile.type &&
                position.equals(tile.position) &&
                color.equals(tile.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, position, color);
    }
}
