package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class XBinarySearchTree<T> implements XBinaryTree<T>{

    public Node<T> root;
    private Comparator<T> comparator;
    private int size;
    private int height;

    public XBinarySearchTree() {
        root = null;
        comparator = null;
        size = 0;
        height = -1;
    }

    public XBinarySearchTree(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
        size = 0;
        height = 0;
    }

    private int compare(T data, T value, Comparator<T> comparator ) {
        if (comparator == null) {
            Comparable<? super T> key = (Comparable<? super T>) value;
            return key.compareTo(data);
        }
        else {
            return comparator.compare(value, data);
        }
    }

    @Override
    public void insert(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        if (root == null) {
            root = new Node<>(value);
            size++;
            return;
        }
        root = insertGo(root, value);
    }

    private Node<T> insertGo(Node<T> node, T value) {
        if (node == null) {
            size++;
            return new Node<>(value);
        }
        int compare = compare(node.data, value, comparator);
        if (compare == 0) {
            return node;
        }
        else if (compare < 0) {
            node.left = insertGo(node.left, value);
            return node;
        }
        else {
            node.right = insertGo(node.right, value);
            return node;
        }
    }

    @Override
    public boolean search(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        if (root == null) {
            root = new Node<>(value);
            return false;
        }
        return searchGo(root, value);
    }

    private boolean searchGo(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        int compare = compare(node.data, value, comparator);
        if (compare == 0) {
            return true;
        }
        else if (compare < 0) {
            return searchGo(node.left, value);
        }
        else {
            return searchGo(node.right, value);
        }
    }

    @Override
    public void delete(T value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        }
        if (root == null) {
            root = new Node<>(value);
            return;
        }
        root = deleteGo(root, value);
    }

    private Node<T> deleteGo(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int compare = compare(node.data, value, comparator);
        if (compare == 0) {
            size--;
            if (node.left == null && node.right == null) {
                return null;
            }
            else if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                return highToHigh(node.left, node.right);
            }
        }
        else if (compare < 0) {
            node.left = deleteGo(node.left, value);
            return node;
        }
        else {
            node.right = deleteGo(node.right, value);
            return node;
        }
    }

    private Node<T> highToHigh(Node<T> node, Node<T> high) {
        if (node.right == null) {
            node.right = high;
            return node;
        }
        else {
            return highToHigh(node.right, high);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        height = 0;
        getHeight(root, height);
        if (root == null) {
            height = -1;
        }
        return this.height;
    }

    private void getHeight(Node<T> node, int height) {
        if (node == null) {
            return;
        }
        this.height = Math.max(height, this.height);
        if (node.left != null) {
            getHeight(node.left, height + 1);
        }
        if (node.right != null) {
            getHeight(node.right, height + 1);
        }
    }

    @Override
    public List inorderTraversal() {
        ArrayList<T> result = new ArrayList<>();
        inorderGo(root, result);
        return result;
    }

    private void inorderGo(Node<T> cur, ArrayList<T> list) {
        if (cur.left != null) {
            inorderGo(cur.left, list);
        }
        list.add(cur.data);
        if (cur.right != null) {
            inorderGo(cur.right, list);
        }
    }
}
