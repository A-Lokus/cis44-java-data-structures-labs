import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E>{
    private Object[] array;
    private int t = -1;
    private static final int BASE_SIZE = 100;

    public ArrayStack(){
        array = new Object[BASE_SIZE];
    }
    public ArrayStack(int s){
        array = new Object[s];
    }


    @Override
    public void push(E e) throws StackOverflowError{
        if(size() == array.length){
            throw new StackOverflowError("Stack is full");
        }
        t++;
        array[t] = e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E ans = (E) array[t];
        array[t] = null;
        t--;
        return ans;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E top() {
        return (E)array[t];
    }

    @Override
    public int size() {
        return t+1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }
}
