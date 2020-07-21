package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[])new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if(last == capacity) {
            last = 0;
        }
        if(isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        last += 1;
        fillCount +=1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if(first == capacity) {
            first = 0;
        }
        if(isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T returnItem = rb[first];
        rb[first] = null;
        first += 1;
        fillCount = fillCount - 1;
        return returnItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if(isEmpty()) {
            System.out.println("The queue is empty!");
        }
        if(first == capacity) {
            first = 0;
        }
        T returnItem = rb[first];
        return returnItem;
    }

    public Iterator<T> iterator() {
        return new bufferIterator();
    }

    private class bufferIterator implements Iterator<T> {
        private int pos;
        public bufferIterator() {
            pos = first;
        }
        public boolean hasNext() {
            if (pos == capacity) {
                pos = 0;
            }
            return ((pos - first) < fillCount);
        }
        public T next() {
            T returnitem = rb[pos];
            pos = pos + 1;
            return returnitem;
        }
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
