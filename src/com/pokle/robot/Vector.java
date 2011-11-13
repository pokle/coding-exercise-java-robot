package com.pokle.robot;

public class Vector {


    public final int x;
    public final int y;
    public final Cardinal direction;

    public Vector(int x, int y, Cardinal direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Vector move() {
        return new Vector(x + direction.deltaX, y + direction.deltaY, direction);
    }

    public Vector left() {
        return new Vector(x, y, direction.left());
    }

    public Vector right() {
        return new Vector(x, y, direction.right());
    }

    public String toString() {
        return "Vector<" + x + "," + y + "," + direction + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            Vector otherVector = (Vector) obj;
            return x == otherVector.x && y == otherVector.y && direction == otherVector.direction;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return x + y + direction.hashCode();
    }

}
