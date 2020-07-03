public class ArrayDeque <T>{
    private T item[];
    private int size;
    private int nextFirst = 7;
    private int nextLast = 0;

    public ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return item[index];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void printDeque() {
        for(T i: item) {
            System.out.print(i + " ");
        }
    }


    public void resize() {
        T[] a = (T[]) new Object[item.length * 2];
        System.arraycopy(item, 0, a, 0, nextFirst + 1);
        if ((nextFirst + 1) != item.length) {
            System.arraycopy(item, nextFirst + 1, a, item.length + nextFirst + 1, item.length - nextFirst - 1);
        }
        item = a;
        nextFirst = nextFirst + a.length / 2;
    }

    /** 2nd way to approach resize
     public void resize() {
     T[] a = (T[]) new Object[item.length * 2];
     System.arraycopy(item, 0, a, 0, size);
     item = a;
     nextFirst = a.length - 1;
     nextLast = a.length / 2;
     }
     */

    public void addFirst(T x) {
        if (nextFirst == - 1) {
            nextFirst = item.length - 1;
        }

        if (nextFirst == nextLast) {
            resize();
        }
        /**
         if (size == item.length) {
            resize();
         }
         */

        item[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
    }

    public void addLast(T x) {
        if (nextLast == item.length) {
            nextLast = 0;
        }

        if (nextFirst == nextLast) {
            resize();
        }
        /**
         if (size == item.length) {
         resize();
         }
         */

        item[nextLast] = x;
        nextLast += 1;
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T f = item[nextFirst + 1];
        item[nextFirst + 1] = null;
        size -= 1;
        nextFirst += 1;
        return f;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T l = item[nextLast - 1];
        item[nextLast - 1] = null;
        size -= 1;
        nextLast -= 1;
        return l;
    }

}
