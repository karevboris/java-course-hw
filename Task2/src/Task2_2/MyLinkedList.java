package Task2_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Boris on 22.10.2017.
 */
public class MyLinkedList<E> implements ILinkedList<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private Node<E> getNode(int index){
        Node<E> e = first;
        for (int i=0; i<index; i++) e = e.getNextNode();
        return e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public void add(E element) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(element, null);
        last = newNode;
        if (oldLast == null)
            first = newNode;
        else
            oldLast.setNextNode(newNode);
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index<0||index>size) throw new IndexOutOfBoundsException();
        if(index==size)add(element);
        else {
            Node<E> newNode;
            if (index==0) {
                newNode = new Node<E>(element,first);
                first = newNode;
            }
            else{
                newNode = new Node<E>(element, getNode(index));
                getNode(index-1).setNextNode(newNode);
            }
            size++;
        }

    }

    @Override
    public void clear() {
        for (Node<E> i = first; i != null; ) {
            Node<E> next = i.getNextNode();
            i.setElement(null);
            i.setNextNode(null);
            i = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index<0||index>size) throw new IndexOutOfBoundsException();
        return getNode(index).getElement();
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> i = first; i != null; i = i.getNextNode()) {
                if (i.getElement() == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> i = first; i != null; i = i.getNextNode()) {
                if (element.equals(i.getElement()))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index<0||index>size) throw new IndexOutOfBoundsException();
        E element = null;
        if(index==0){
            Node<E> next = first.getNextNode();
            element = first.getElement();
            first.setElement(null);
            first.setNextNode(null);
            first = next;
        }
        if (index == size){
            Node<E> prev = getNode(index-1);
            element = last.getElement();
            last.setElement(null);
            last.setNextNode(null);
            last = prev;
        }
        else {
            Node<E> prev = getNode(index-1);
            Node<E> remove = prev.getNextNode();
            Node<E> next = remove.getNextNode();
            element = remove.getElement();
            remove.setElement(null);
            remove.setNextNode(null);
            prev.setNextNode(next);
        }
        size--;
        return element;
    }

    @Override
    public E set(int index, E element) {
        if (index<0||index>size) throw new IndexOutOfBoundsException();
        Node<E> node = getNode(index);
        E res = node.getElement();
        node.setElement(element);
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (Node<E> i = first; i != null; i = i.getNextNode())
            result[index++] = i.getElement();
        return result;
    }

    private class MyIterator implements Iterator<E> {

        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        public MyIterator(int nextIndex) {
            if (nextIndex == size) next = null;
            else{
                Node<E> e = first;
                for (int i = 0; i < nextIndex; i++)
                    e = e.getNextNode();
                next = e;
            }
            this.nextIndex = nextIndex;
        }

        public MyIterator() {
            nextIndex = 0;
            next = first;
        }

        @Override
        public boolean hasNext() {
            return (next!=null);
        }

        @Override
        public E next() {
            if(hasNext()) {
                E e = next.getElement();
                next = next.getNextNode();
                nextIndex++;
                return e;
            }
            else
                throw new NoSuchElementException();
        }
    }
}