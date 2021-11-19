import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array; // I choose array since it's easier to access a random index
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[2]; // size of array = 2 to deal with the first two enqueue operations
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size == array.length) resize(2 * array.length);

        // if the queue is empty
        if (size == 0) {
            array[size++] = item;
            return;
        }

        // insert the item at a random index and put the old element as the new last element
        int randomIndex = StdRandom.uniform(size);
        Item temp = array[randomIndex];
        array[randomIndex] = item;
        array[size++] = temp;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (size > 0 && size == array.length / 4) resize(array.length / 2);

        // replace the item at a random index with the last element
        int randomIndex = StdRandom.uniform(size);
        Item item = array[randomIndex];
        array[randomIndex] = array[--size];
        array[size] = null; // to prevent loitering
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return array[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i;
        private int[] randomIndices;
        public ArrayIterator() {
            i = 0;
            randomIndices = new int[size];
            for (int j = 0; j < size; j++) {
                randomIndices[j] = j;
            }
            StdRandom.shuffle(randomIndices);
        }
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[randomIndices[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // resize array when necessary
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            randomizedQueue.enqueue(i);
        }
        StdOut.println("Dequeue: " + randomizedQueue.dequeue());
        StdOut.println("Size: " + randomizedQueue.size());
        StdOut.println("Is empty? " + randomizedQueue.isEmpty());
        StdOut.println("Sample: " + randomizedQueue.sample());
        for (Integer integer : randomizedQueue) {
            StdOut.println(integer);
        }
    }

}