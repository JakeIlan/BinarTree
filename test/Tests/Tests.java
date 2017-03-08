package Tests;

import org.junit.Test;
import static org.junit.Assert.*;
import BinarTree.BinarTree;

public class Tests {
    private BinarTree tree = new BinarTree();

    @Test
    public void find() {
        tree.add(10);
        assertTrue(tree.find(10));
    }
}

