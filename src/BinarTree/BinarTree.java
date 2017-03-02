package BinarTree;

import java.util.Collection;
import java.util.IllegalFormatException;

/**
 * Created by DEXPPC on 14.88.1337.
 */

public class BinarTree {
    private Cell root;

    public class Cell {
        private Cell parent;
        private Cell left;
        private Cell right;
        private int key;

        public int getKey() {
            return key;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;
            return ((Cell) obj).key == other.key;
        }
        return false;
    }

    public boolean find(int x) {
        if (root == null) return false;
        else {
            Cell temp = root;
            while (temp != null) {
                if (temp.key == x) {
                    temp = null;
                    return true;
                }
                if (x < temp.key) temp = temp.left;
                if (x > temp.key) temp = temp.right;
            }
        }
        return false;
    }

    public void add(int x) {
        if (!find(x)) {
            if (root == null) {
                Cell root = new Cell();
                root.key = x;
            } else {
                Cell temp = root;
                while (true) {
                    if (x < temp.key) {
                        if (temp.left == null) {
                            Cell cell = new Cell();
                            cell.key = x;
                            cell.parent = temp;
                            temp.left = cell;
                            break;
                        } else temp = temp.left;

                    }
                    if (x > temp.key) {
                        if (temp.right == null) {
                            Cell cell = new Cell();
                            cell.key = x;
                            cell.parent = temp;
                            temp.right = cell;
                            break;
                        } else temp = temp.right;

                    }
                }
            }
        }
    }

    public void remove(int x) {
        if (find(x)) {

        }
    }
}