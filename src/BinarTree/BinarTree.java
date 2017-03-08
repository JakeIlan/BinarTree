package BinarTree;

import java.util.Collection;
import java.util.IllegalFormatException;

/**
 * Created by DEXPPC on 14.88.1337.
 */

public class BinarTree {
    public  BinarTree(){

    }
    private Cell root;
    public class Cell {
        private Cell parent;
        private Cell left;
        private Cell right;
        private int key;

        public int getKey() {
            return key;
        }

        private Cell(int x) {
            this.key = x;
        }

    }

    public Cell findCell(int x) {
        Cell temp = root;
        if (temp == null) return null;
        while (temp.key != x) {
            if (x < temp.key) temp = temp.left;
            else temp = temp.right;
            if (temp == null) return null;
        }
        return temp;
    }

    public boolean find(int x) {
        return (findCell(x) != null);
    }

    public void add(int x) {
        Cell newCell = new Cell(x);
        if (!find(x)) {
            if (root == null) root = newCell;
            else {
                Cell temp = root;
                while (temp != newCell) {
                    Cell parent = temp;
                    if (x < temp.key) {
                        temp = temp.left;
                        if (temp == null) {
                            parent.left = newCell;
                            newCell.parent = parent;
                            temp = newCell;
                        }
                    } else {
                        temp = temp.right;
                        if (temp == null) {
                            parent.right = newCell;
                            newCell.parent = parent;
                            temp = newCell;
                        }
                    }
                }
            }
        }
    }

    public void remove(int x) {
        if (find(x)) {

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

}