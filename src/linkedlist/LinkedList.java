package linkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++sizeOfList;
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertDataAtTheBeginning(data);
        }
    }

    private void insertDataAtTheBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    private void insertDataAtTheEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertDataAtTheEnd(data, node.getNextNode());
        } else {
            Node<T> tNode = new Node<>(data);
            node.setNextNode(tNode);
        }
    }

    @Override
    public void remove(T data) {
        if (root == null) return;
        --sizeOfList;
        if (root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previous, Node<T> actual) {
        while (actual != null) {
            if (actual.getData().compareTo(data) == 0) {
                previous.setNextNode(actual.getNextNode());
                actual = null;
                return;
            }
        }
        previous = actual;
        actual = actual.getNextNode();
    }

    @Override
    public void traverseList() {
        if (root == null) return;
        Node<T> actual = this.root;
        while (actual != null) {
            System.out.println("Actual = ");
            actual = actual.getNextNode();
        }
    }

    @Override
    public int size() {
        return sizeOfList;
    }
}
