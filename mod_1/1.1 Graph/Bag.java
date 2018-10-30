/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The <tt>Bag</tt> class represents a bag (or multiset) of generic items. It
 * supports insertion and iterating over the items in arbitrary order. <p> The
 * <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation take constant
 * time. Iteration takes time proportional to the number of items. <p> For
 * additional documentation, see <a
 * href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     *  number of elements in bag.
     */
    private int n;
    /**
     *beginning of bag
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * Item type item.
         */
        private Item item;
        /**
         * Integer value.
         */
        private int value;
        /**
         * data of next node.
         */
        private Node next;
        /**
         * Constructs the object.
         */
        Node() {

        }
        /**
         * Constructs the object.
         *
         * @param      i  The item
         * @param      v  The value
         */
        Node(final Item i, final int v) {
            this.item = i;
            this.value = v;
        }
    }

   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        n = 0;
    }

   /**
     * Is the BAG empty?
     * @return boolean.
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Size of bag.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }

   /**
     * Add the item to the bag.
     * @return item.
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
    // an iterator, doesn't implement remove() since it's optional
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * Starting node.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**
         * remove item.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next item is defined.
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}



