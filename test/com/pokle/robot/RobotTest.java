package com.pokle.robot;

import org.junit.Test;

import static com.pokle.robot.Direction.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RobotTest {

    public static Vector v(int x, int y, Direction direction) {
        return new Vector(x, y, direction);
    }

    private static Vector placeAndMove(Vector initial) {
        Robot r = new Robot();
        r.place(initial);
        r.move();
        return r.getVector();
    }

    @Test
    public void shouldNotMoveIfNotPlaced() {
        Robot r = new Robot();
        Vector initialLocation = r.getVector();
        r.move();
        assertThat(r.getVector(), equalTo(initialLocation));
    }

    @Test
    public void shouldMoveIfPlaced() {
        Robot r = new Robot();
        r.place(v(0, 0, NORTH));
        Vector initialLocation = r.getVector();
        r.move();
        assertThat(r.getVector(), not(equalTo(initialLocation)));
    }

    @Test
    public void shouldNotTurnLeftIfNotPlaced() {
        Robot r = new Robot();
        Vector initial = r.getVector();
        r.left();
        assertThat(r.getVector(), equalTo(initial));
    }

    @Test
    public void shouldTurnLeftIfPlaced() {
        Robot r = new Robot();
        r.place(v(2,2,NORTH));
        Vector initial = r.getVector();
        r.left();
        assertThat(r.getVector(), not(equalTo(initial)));
    }

    @Test
    public void shouldNotTurnRightIfNotPlaced() {
        Robot r = new Robot();
        Vector initial = r.getVector();
        r.right();
        assertThat(r.getVector(), equalTo(initial));
    }

    @Test
    public void shouldTurnRightIfPlaced() {
        Robot r = new Robot();
        r.place(v(2,2,NORTH));
        Vector initial = r.getVector();
        r.right();
        assertThat(r.getVector(), not(equalTo(initial)));
    }

    @Test
    public void shouldMoveNorth() {
        assertThat(placeAndMove(v(0, 0, NORTH)), equalTo(v(0, 1, NORTH)));
    }

    @Test
    public void shouldMoveSouth() {
        assertThat(placeAndMove(v(1, 1, SOUTH)), equalTo(v(1, 0, SOUTH)));
    }

    @Test
    public void shouldMoveEast() {
        assertThat(placeAndMove(v(0, 0, EAST)), equalTo(v(1, 0, EAST)));
    }

    @Test
    public void shouldMoveWest() {
        assertThat(placeAndMove(v(1, 0, WEST)), equalTo(v(0, 0, WEST)));
    }

    @Test
    public void mustNotFallOffTheTable() {
        assertThat(placeAndMove(v(0, 0, SOUTH)), equalTo(v(0, 0, SOUTH)));
    }
}
