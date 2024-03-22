package csc241.ds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestExpandableArray {

    @Test
    public void testRemoveAtStart() {
        // Setup.
        ExpandableArray ea = new ExpandableArray();
        ea.add("a"); ea.add("b"); ea.add("c");

        ea.remove(0);
        assertNotEquals("a", ea.get(0));
        assertEquals("b", ea.get(0));
        assertEquals(2, ea.size());
    }

    @Test
    public void testRemoveAtMiddle() {
        // Setup.
        ExpandableArray ea = new ExpandableArray();
        ea.add("a"); ea.add("b"); ea.add("c");

        ea.remove(1);
        assertNotEquals("b", ea.get(1));
        assertEquals("c", ea.get(1));
        assertEquals(2, ea.size());
    }

    @Test
    public void testRemoveAtEnd() {
        // Setup.
        ExpandableArray ea = new ExpandableArray();
        ea.add("a"); ea.add("b"); ea.add("c");

        ea.remove(2);
        assertNotEquals("c", ea.get(1));
        assertEquals(2, ea.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveAtNegativeIndex() {
        ExpandableArray ea = new ExpandableArray();

        ea.remove(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveAtBigIndex() {
        ExpandableArray ea = new ExpandableArray();

        ea.remove(1);
    }

}
