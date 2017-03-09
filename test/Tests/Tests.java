package Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import BinarTree.BinarTree;

public class Tests {
    private BinarTree tree = new BinarTree();

    @Test
    public void find() {
        tree.add(10);
        tree.add(5);
        assertTrue(tree.find(10));
        assertTrue(tree.find(5));
    }

    @Test
    public void remove() {
        tree.add(10);
        tree.add(5);
        tree.remove(5);
        assertFalse(tree.find(5));
    }

    @Test
    public void remove1() {
        tree.add(10);
        tree.add(15);
        tree.add(17);
        tree.remove(15);
        assertTrue(tree.find(17));
        assertEquals("Right - 17;", tree.infoRight(10));
    }

    @Test
    public void remove2() {
        tree.add(10);
        tree.add(5);
        tree.add(7);
        tree.add(2);
        tree.add(15);
        tree.add(17);
        tree.remove(5);
        assertTrue(tree.find(2));
        assertTrue(tree.find(7));
        assertEquals("Right - 7;", tree.infoRight(2));
        assertEquals("Left - 2;", tree.infoLeft(10));
    }
}

