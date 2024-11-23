package com.coffeeisoxygen.model.classes;

import java.util.Objects;

import com.coffeeisoxygen.model.interfaces.IPoint;

public class Point implements IPoint {
    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow((double) this.x - other.x, 2) + Math.pow((double) this.y - other.y, 2));
    }

    @Override
    public int manhattanDistanceTo(Point other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    @Override
    public IPoint directionTo(Point other) {
        return Point.of(other.x - this.x, other.y - this.y);
    }

    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public IPoint copy() {
        return Point.of(this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}