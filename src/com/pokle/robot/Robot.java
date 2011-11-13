package com.pokle.robot;

public class Robot {

    private static final Bounds table = new Bounds(0,0,4,4);
    private Vector vector;

    public void place(Vector vector) {
        this.vector = vector;
    }

    public Vector move() {
        if (vector != null) {
            Vector proposed = vector.move();
            if (table.contains(proposed.x, proposed.y)) {
                vector = proposed;
            }
        }
        return vector;
    }

    public Vector left() {
        if (vector != null) {
            vector = vector.left();
        }
        return vector;
    }

    public Vector right() {
        if (vector != null) {
            vector = vector.right();
        }
        return vector;
    }


    public Vector getVector() {
        return vector;
    }

}
