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
        if (!find(x)) {
            Cell newCell = new Cell(x);
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
            Cell delCell = findCell(x);
            Cell parent = delCell.parent;
            Cell left = delCell.left;
            Cell right = delCell.right;
            if (left == null && right == null) {
                if (x < parent.key) parent.left = null;
                else parent.right = null;
            } else if (left == null) {
                if (x > parent.key) parent.right = right;
                else parent.left = right;
                right.parent = parent;
            } else if (right == null) {
                if (x > parent.key) parent.right = left;
                else parent.left = left;
                left.parent = parent;
            } else {
                if (left.right == null) {
                    if (x > parent.key) parent.right = left;
                    else parent.left = left;
                    left.right = delCell.right;
                } else {
                    Cell temp = left.right;
                    Cell tempParent = left;
                    while (temp.right != null) {
                        tempParent = temp;
                        temp = temp.right;
                    }
                    delCell.key = temp.key;
                    if (temp.left == null) tempParent.right = null;
                    else {
                        tempParent.right = temp.left;
                        temp.left.parent = tempParent;
                    }
                }
            }
        }
    }

    public String info(int key) {
        Cell cell = findCell(key);
        return ("Parent - " + cell.parent.key + "; Left Child - " + cell.left.key + "; Right Child - " + cell.right.key);
    }

    public String infoParent(int key) {
        Cell cell = findCell(key);
        return ("Parent - " + cell.parent.key + ";");
    }

    public String infoLeft(int key) {
        Cell cell = findCell(key);
        return ("Left - " + cell.left.key + ";");
    }

    public String infoRight(int key) {
        Cell cell = findCell(key);
        return ("Right - " + cell.right.key + ";");
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