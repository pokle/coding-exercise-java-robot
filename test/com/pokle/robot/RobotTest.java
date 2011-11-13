package com.pokle.robot;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static com.pokle.robot.Cardinal.*;
import static org.junit.Assert.assertThat;

public class RobotTest {

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
        r.place(v(0,0, NORTH));
        Vector initialLocation = r.getVector();
        r.move();
        assertThat(r.getVector(), not(equalTo(initialLocation)));
    }

    private static Vector v(int x, int y, Cardinal direction) {
        return new Vector(x, y, direction);
    }

    private static Vector placeAndMove(Vector initial) {
        Robot r = new Robot();
        r.place(initial);
        r.move();
        return r.getVector();
    }

    @Test
    public void shouldMoveNorth() {
        assertThat(placeAndMove(v(0,0,NORTH)), equalTo(v(0, 1, NORTH)));
    }

    @Test
    public void shouldMoveSouth() {
        assertThat(placeAndMove(v(1,1,SOUTH)), equalTo(v(1, 0, SOUTH)));
    }

    @Test
    public void shouldMoveEast() {
        assertThat(placeAndMove(v(0,0,EAST)), equalTo(v(1, 0, EAST)));
    }

    @Test
    public void shouldMoveWest() {
        assertThat(placeAndMove(v(1,0,WEST)), equalTo(v(0, 0, WEST)));
    }

    private static Cardinal leftOf(Cardinal origin) {
        Robot r = new Robot();
        r.place(v(0, 0, origin));
        return r.left().direction;
    }

    @Test
    public void leftOfNorthIsWest() {
        assertThat(leftOf(NORTH), equalTo(WEST));
    }

    @Test
    public void leftOfWestIsSouth() {
        assertThat(leftOf(WEST), equalTo(SOUTH));
    }

    @Test
    public void leftOfSouthIsEast() {
        assertThat(leftOf(SOUTH), equalTo(EAST));
    }

    @Test
    public void leftOfEastIsNorth() {
        assertThat(leftOf(EAST), equalTo(NORTH));
    }
}
