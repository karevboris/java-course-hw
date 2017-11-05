package Task2_2;

/**
 * Created by Boris on 22.10.2017.
 */
public class Node<E> {

    private E element;
    private Node nextNode;

    public Node(E element, Node nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
