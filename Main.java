public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<>();

        Integer[] array = {56, 30, 20, 40, 11, 3, 16, 70, 60, 95, 65, 63, 67};

        for (Integer ele : array) {
            tree.insert(ele);
        }

        System.out.println("Tree Has");
        tree.print();

        System.out.println();

        if (tree.size() == array.length) {
            System.out.println("Every element is inserted in the tree");
        } else {
            System.out.println("Not Inserted Completely");
        }

        if (tree.search(63)) {
            System.out.println("Node is Present");
        } else {
            System.out.println("Node is not present");
        }
    }
}

class Node<T> {

    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this.data = data;
    }
}

class BinaryTree<T extends Comparable<T>> {

    Node<T> root;

    public void insert(T data) {
        root = insertRec(root, data);
    }

    public Node<T> insertRec(Node<T> root, T data) {

        if (root == null) {
            root = new Node<>(data);
        }

        else if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        }

        else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void print() {
        printRec(root);
    }

    public void printRec(Node<T> root) {

        if (root != null) {

            printRec(root.left);

            System.out.print(root.data + " ");

            printRec(root.right);
        }
    }

    public int size() {
        return sizeOfTree(root);
    }

    public int sizeOfTree(Node<T> root) {

        if (root == null) {
            return 0;
        }

        int s1 = sizeOfTree(root.left);
        int s2 = sizeOfTree(root.right);

        return s1 + s2 + 1;
    }

    public boolean search(T data) {
        return searchTree(data, root);
    }

    public boolean searchTree(T data, Node<T> root) {

        if (root != null) {

            if (data.compareTo(root.data) == 0) {
                return true;
            }

            else if (data.compareTo(root.data) < 0) {
                return searchTree(data, root.left);
            }

            else if (data.compareTo(root.data) > 0) {
                return searchTree(data, root.right);
            }
        }

        return false;
    }
}