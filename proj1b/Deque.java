public interface Deque<T> {

    boolean isEmpty();
    T get(int index);
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    int size();
    void printDeque();

}
