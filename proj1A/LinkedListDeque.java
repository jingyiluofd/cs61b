
import java.util.Formatter;

public class LinkedListDeque<Generic> {


    private class IntNode {
        IntNode prev;
        Generic item;
        IntNode next;
        public IntNode( Generic i) {
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
            addLast((Generic) other.get(i));
            size = size + 1;
        }
    }

    /* Adds an item of type Generic to the front of the deque. */
    public void addFirst(Generic T) {
        IntNode p = new IntNode(T);
        p.next = sentinel.next;
        sentinel.next = p;
        p.prev = sentinel;
        p.next.prev = p;
        size = size + 1;

    }

    /* Adds an item of type Generic to the back of the deque. */
    public void addLast(Generic T){
        IntNode p = new IntNode(T);
        p.prev = sentinel.prev;
        sentinel.prev = p;
        p.next = sentinel;
        p.prev.next =p;
        size = size + 1 ;

    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return (sentinel.next == sentinel && sentinel.prev == sentinel);
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.*/
    public void printDeque() {
        IntNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.print("\n");

    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public Generic removeFirst() {
        if (isEmpty() == true){
            return null;
        }
        Generic value;
        value = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return value;
    }

    /* Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public Generic removeLast() {
        if (isEmpty() == true){
            return null;
        }
        Generic value;
        value = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return value;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque! */
    public Generic get(int index) {

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
    private Generic getRecursiveHelper(IntNode p, int index) {

        if(index == 0){
            return p.item;
        }
        return getRecursiveHelper(p.next, index-1);

    }

    /* Same as get, but uses recursion */
    public Generic getRecursive(int index) {
        if(index < 0 || index >= size() || size() <= 0 ) {
            return null;
        }

        IntNode p = sentinel.next;

        return (getRecursiveHelper(p, index));
    }

}