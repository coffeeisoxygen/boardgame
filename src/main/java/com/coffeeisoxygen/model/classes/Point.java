package com.coffeeisoxygen.model.classes;

import java.util.Objects;

import com.coffeeisoxygen.model.interfaces.IPoint;

/**
 * A class representing a 2D point with x and y coordinates.
 */
public class Point implements IPoint {
    /**
     * The x-coordinate of the point.
     */
    private int x;

    /**
     * The y-coordinate of the point.
     */
    private int y;

    /**
     * Creates a new point with the given x and y coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the point.
     *
     * @return the x-coordinate
     */

    @Override
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the point.
     *
     * @param x the new x-coordinate
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y-coordinate of the point.
     *
     * @return the y-coordinate
     */

    @Override
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the point.
     *
     * @param y the new y-coordinate
     */

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Calculates the Euclidean distance to another point.
     *
     * @param other the other point
     * @return the Euclidean distance between this point and the other point
     */
    @Override
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow((double) this.x - other.x, 2) + Math.pow((double) this.y - other.y, 2));
    }

    /**
     * Calculates the Manhattan distance to another point.
     *
     * @param other the other point
     * @return the Manhattan distance between this point and the other point
     */
    @Override
    public int manhattanDistanceTo(Point other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    /**
     * Calculates the direction vector to another point.
     *
     * @param other the other point
     * @return a new point representing the direction vector
     */
    @Override
    public IPoint directionTo(Point other) {
        return new Point(other.x - this.x, other.y - this.y);
    }

    /**
     * Translates this point by the given delta values.
     *
     * @param dx the change in the x-coordinate
     * @param dy the change in the y-coordinate
     */
    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Creates a copy of this point.
     *
     * @return a new point with the same x and y coordinates
     */
    @Override
    public IPoint copy() {
        return new Point(this.x, this.y);
    }

    /**
     * Checks if this point is equal to another object.
     *
     * @param o the object to compare
     * @return true if the object is a point with the same coordinates, false
     *         otherwise
     */

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    /**
     * Computes a hash code for this point based on its coordinates.
     *
     * @return the hash code
     */

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Returns a string representation of this point.
     *
     * @return a string representation in the format "Point{x=X, y=Y}"
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
