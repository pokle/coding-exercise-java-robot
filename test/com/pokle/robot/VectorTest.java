package com.pokle.robot;

import org.junit.Test;

import static com.pokle.robot.Direction.*;
import static com.pokle.robot.RobotTest.v;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class VectorTest {

    private static Direction leftOf(Direction origin) {
        return v(0, 0, origin).left().direction;
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

    private static Direction rightOf(Direction origin) {
        return v(0, 0, origin).right().direction;
    }

    @Test
    public void rightOfNorthIsEast() {
        assertThat(rightOf(NORTH), equalTo(EAST));
    }

    @Test
    public void rightOfEastIsSouth() {
        assertThat(rightOf(EAST), equalTo(SOUTH));
    }

    @Test
    public void rightOfSouthIsWest() {
        assertThat(rightOf(SOUTH), equalTo(WEST));
    }

    @Test
    public void rightOfWestIsNorth() {
        assertThat(rightOf(WEST), equalTo(NORTH));
    }

}
