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
}

