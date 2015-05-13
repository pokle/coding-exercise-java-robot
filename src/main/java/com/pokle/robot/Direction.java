package com.pokle.robot;

public enum Direction {

    NORTH(0, 1), SOUTH(0, -1), EAST(1, 0), WEST(-1, 0);

    public final int deltaX;
    public final int deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public Direction left() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                throw new IllegalStateException("Lazy programmer forgot to add a direction to left(): " + this);
        }
    }

    public Direction right() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("Lazy programmer forgot to add a direction to right(): " + this);
        }
    }
}
