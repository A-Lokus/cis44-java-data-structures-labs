import java.util.Iterator;

public class LinkedPositionalList<E> implements Iterable<E>{
    private static class Node<E> implements Position<E>{
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement(){
            return element;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public LinkedPositionalList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
        size = 0;
    }


    private Node<E> validatePos(Position<E> p){
        if(p instanceof Node<E> && !(((Node<E>)p).next == null && ((Node<E>)p).prev == null)){
            return (Node<E>)p;
        }
        else{
            throw new IllegalArgumentException();
        }
    }


    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public Position<E> first(){
        return header.next;
    }
    public Position<E> last(){
        return trailer.prev;
    }
    public Position<E> before(Position<E> p){
        return (validatePos(p)).next;
    }
    public Position<E> after(Position<E> p){
        return (validatePos(p)).next;
    }



    public Position<E> addFirst(E e){
        Node<E> newNode = new Node<E>(e, header, header.next);
        header.next.prev = newNode;
        header.next = newNode;
        size++;
        return newNode;
    }
    public Position<E> addLast(E e){
        Node<E> newNode = new Node<E>(e, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
        return newNode;
    }
    public Position<E> addBefore(Position<E> p, E e){
        Node<E> posNode = validatePos(p);
        Node<E> newNode = new Node<E>(e, posNode.prev, posNode);
        posNode.prev.next = newNode;
        posNode.prev = newNode;
        size++;
        return posNode.prev;
    }
    public Position<E> addAfter(Position<E> p, E e){
        Node<E> posNode = validatePos(p);
        Node<E> newNode = new Node<E>(e, posNode, posNode.next);
        posNode.next.prev = newNode;
        posNode.next = newNode;
        size++;
        return posNode.next;
    }
    public Position<E> set(Position<E> p, E e){
        Node<E> node = validatePos(p);
        E removed = node.element;
        node.element = e;
        return node;
    }
    public Position<E> remove(Position<E> p){
        Node<E> node = validatePos(p);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node;
    }

    private class ElementIterator implements Iterator<E>{
        Position<E> cursor = first();

        public boolean hasNext(){
            return cursor != null && after(cursor) != null;
        }
        public E next(){
            E e = cursor.getElement();
            cursor = after(cursor);
            return e;
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new ElementIterator();
    }
}