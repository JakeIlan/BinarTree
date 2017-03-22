package BinarTree;

import java.util.ArrayList;
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

        public int getKey(int x) {
            Cell cell = findCell(x);
            return cell.key;
        }

        public Cell getLeft(int x) {
            Cell cell = findCell(x);
            return cell.left;
        }

        public Cell getRight(int x) {
            Cell cell = findCell(x);
            return cell.right;
        }

        public Cell getParent(int x) {
            Cell cell = findCell(x);
            return cell.parent;
        }

        private Cell(int x) {
            this.key = x;
        }

        @Override
        public String toString() {
            return ("Key - " + key + "; Parent - " + parent.key + "; Left Child - " + left.key + "; Right Child - " + right.key);
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + key;
            return result;
        }
    }

    private ArrayList<Integer> elements = new ArrayList<>();

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
                        elements.add(x);
                    }
                } else {
                    temp = temp.right;
                    if (temp == null) {
                        parent.right = newCell;
                        newCell.parent = parent;
                        temp = newCell;
                        elements.add(x);
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
            elements.remove(x);
        }
    }



    public String infoString(int x) {
        Cell cell = findCell(x);
        return ("Parent - " + cell.parent.key + "; Left Child - " + cell.left.key + "; Right Child - " + cell.right.key);
    }

    public int infoParent(int x) {
        return findCell(x).parent.key;
    }

    public int infoLeft(int x) {
        return findCell(x).left.key;
    }

    public int infoRight(int x) {
        return findCell(x).right.key;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        BinarTree other = (BinarTree) obj;
        if (elements == other.elements) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < elements.size() - 1; i++) {
            result = 31 * result + elements.get(i);
        }
        return result;
    }

}