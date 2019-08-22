
import java.util.Formatter;

public class LinkedListDeque<T> implements Deque<T>{


    private class IntNode {
        IntNode prev;
        T item;
        IntNode next;
        public IntNode( T i) {
            item = i;
        }

    }

    public int size;
    private IntNode sentinel;

    /* Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new IntNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /* Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new IntNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for ( int i = 0; i < other.size(); i++){
            addLast((T) other.get(i));
            size = size + 1;
        }
    }

    /* Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T T) {
        IntNode p = new IntNode(T);
        p.next = sentinel.next;
        sentinel.next = p;
        p.prev = sentinel;
        p.next.prev = p;
        size = size + 1;

    }

    /* Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T T){
        IntNode p = new IntNode(T);
        p.prev = sentinel.prev;
        sentinel.prev = p;
        p.next = sentinel;
        p.prev.next =p;
        size = size + 1 ;

    }


    /* Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.*/
    @Override
    public void printDeque() {
        IntNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.print("\n");

    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (isEmpty() == true){
            return null;
        }
        T value;
        value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return value;
    }

    /* Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (isEmpty() == true){
            return null;
        }
        T value;
        value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = size - 1;
        return value;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index) {

        IntNode p = sentinel.next;

        if(index < 0 || index >= size ) {
            return null;
        }

        for (int i = 0; i < size; i++ ) {
            if (index == i){
                return p.item;
            }
            p = p.next;
        }
        return null;

    }

    /* helper method for getRecursive */
    private T getRecursiveHelper(IntNode p, int index) {

        if(index == 0){
            return p.item;
        }
        return getRecursiveHelper(p.next, index-1);

    }

    /* Same as get, but uses recursion */
    public T getRecursive(int index) {
        if(index < 0 || index >= size() || size() <= 0 ) {
            return null;
        }

        IntNode p = sentinel.next;

        return (getRecursiveHelper(p, index));
    }

}