public class LinkedListDeque<T> implements Deque<T> {
    private class LinkedNode {
        private T item;
        private LinkedNode prev;
        private LinkedNode next;
        public LinkedNode (T i, LinkedNode p, LinkedNode n) {
             item = i;
             prev = p;
             next = n;
        }
    }

    private LinkedNode sentinel;
    private int size;

    /** Empty linked list Deque. */
    public LinkedListDeque() {
        sentinel = new LinkedNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new LinkedNode(null, null, null);
        sentinel.next = new LinkedNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new LinkedNode(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /** also correct as follows
        public void addFirst(T x) {
        sentinel.next.prev = new LinkedNode(x, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    } */

    @Override
    public void addLast(T x) {
        sentinel.prev = new LinkedNode(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T Firstitem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return Firstitem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T  Lastitem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size -= 1;
        return Lastitem;
    }

    @Override
    public T get(int index) {
        if(index >= size()) {
            return null;
        }
        LinkedNode p = sentinel.next;
        for(int i = 0; i < index; i ++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursiveHelper(LinkedNode q, int index){
        if (index == 0) {
            return q.item;
        }
        else{
            q = q.next;
            index -= 1;
        }
        return getRecursiveHelper(q, index);
    }

    public T getRecursive(int index) {
        if(size() == 0 || index > (size () - 1)){
            return null;
        }
        LinkedNode p = sentinel.next;
        return getRecursiveHelper(p, index);
    }

    @Override
    public void printDeque() {
        LinkedNode p = sentinel;
        while(p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }
}
