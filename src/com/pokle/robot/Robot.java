package com.pokle.robot;

public class Robot {

    private Vector vector;

    public void place(Vector vector) {
        this.vector = vector;
    }

    public Vector move() {
        if (vector != null) {
            vector = vector.move();
        }
        return vector;
    }

    public Vector left() {
        if (vector != null) {
            vector = vector.left();
        }
        return vector;
    }

    public Vector getVector() {
        return vector;
    }

}
