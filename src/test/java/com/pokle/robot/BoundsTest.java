package com.pokle.robot;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoundsTest {

    @Test
    public void containsShouldBeInclusive() {
        Bounds b = new Bounds(0, 0, 1, 1);
        assertTrue(b.contains(0, 0));
        assertTrue(b.contains(0, 1));
        assertTrue(b.contains(1, 0));
        assertTrue(b.contains(1, 1));

        assertFalse(b.contains(-1, -1));
        assertFalse(b.contains(-1, 0));
        assertFalse(b.contains(0, -1));
        assertFalse(b.contains(-1, -1));

        assertFalse(b.contains(2, 2));
        assertFalse(b.contains(2, 0));
        assertFalse(b.contains(0, 2));
        assertFalse(b.contains(2, 2));

    }
}
