/**
 * This deque must use arrays as the core data structure.
 *
 * @param <T>
 *
 * @author ljy
 */
public class ArrayDeque<T> implements Deque<T> {
    /**
     * items size in array deque.
     */
    private int size;
    /**
     * index for the next item added to the front of the deque.
     */
    private int nextFirst;
    /**
     * index for the next item added to the back of the deque.
     */
    private int nextLast;
    /**
     * value of the array deque.
     */
    private T[] items;

    /**
     * an empty array deque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
    }

    /**
     * a deep copy of other.
     *
     * @param other ArrayDeque
     */
    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.items.length];
        size = other.size;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        System.arraycopy(other.items, 0, items, 0, other.items.length);
    }

    /**
     * resize the array deque.
     *
     * @param capacity int
     *
     */

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int first;
        if (nextFirst == items.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        for (int i = 0; i < size; i++) {
            a[i] = get(first);
            first = first + 1;
            if (first == items.length) {
                first = 0;
            }
        }
        items = a;
        nextLast = size;
        nextFirst = items.length - 1;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * @param item T
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 4);
        }
        items[nextFirst] = item;
        size = size + 1;
        nextFirst = nextFirst - 1;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }

    }

    /**
     * Adds an item of type T to the back of the deque.
     * @param item T
     */
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 4);
        }
        items[nextLast] = item;
        size = size + 1;
        nextLast = nextLast + 1;
        if (nextLast == items.length) {
            nextLast = 0;
        }
    }


    /**
     * Returns the number of items in the deque.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
        int first;
        if (nextFirst == items.length - 1) {
            first = 0;
        } else {
            first = nextFirst + 1;
        }
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[first] + " ");
            first = first + 1;
            if (first == items.length) {
                first = 0;
            }
        }
        System.out.print("\n");

    }

    /**
     * Reduce the size of array deque.
     */
    private void reduceSize() {
        double doubleSize = size;
        double val = doubleSize / items.length;
        if ((items.length >= 16) && val < 0.25) {
            resize(size * 4);
        }
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeFirst() {
        T returnValue;
        size = size - 1;
        nextFirst = nextFirst + 1;
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        returnValue = items[nextFirst];
        items[nextFirst] = null;
        reduceSize();
        return returnValue;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     * @return
     */
    @Override
    public T removeLast() {
        T returnValue;
        size = size - 1;
        nextLast = nextLast - 1;
        if (nextLast == -1) {
            nextLast = items.length - 1;
        }
        returnValue = items[nextLast];
        items[nextLast] = null;
        reduceSize();
        return returnValue;
    }

    /**
     * Gets the item at the given index,
     * where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     * @param index int
     * @return
     */
    @Override
    public T get(int index) {
        return items[index];
    }
}
