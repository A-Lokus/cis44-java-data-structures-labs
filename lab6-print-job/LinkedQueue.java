public class LinkedQueue<E> implements Queue<E> {
    private class Node<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            next = p;
            prev = n;
        }
    }

    private Node<E> head = new Node<>(null,null,null);
    private Node<E> tail = new Node<>(null, head, null);
    private int size;

    public LinkedQueue(){
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e,tail.prev,tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        E ans = head.next.element;
        head.next = head.next.next;
        size--;
        return ans;
    }

    @Override
    public E first() {
        return head.next.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
