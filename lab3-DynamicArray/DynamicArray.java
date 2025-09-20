public class DynamicArray<T> {
    private static final int INIT_CAP = 10;
    private T[] data;
    private int numElements;

    @SuppressWarnings("unchecked")
    public DynamicArray(){
        data = (T[]) new Object[INIT_CAP];
        numElements = 0;
    }


    public void add(T element){
        if(numElements == data.length){
            resize();
        }
        data[numElements] = element;
        numElements++;
    }

    public T get(int index) throws IndexOutOfBoundsException{
        if(index >= numElements){throw new IndexOutOfBoundsException("Invalid index: "+index);}
        return data[index];
    }

    public T remove(int index) throws IndexOutOfBoundsException{
        if(index >= numElements){throw new IndexOutOfBoundsException("Invalid index: "+index);}
        T removed = data[index];
        for(int i = index; i < numElements-1; i++){
            data[i] = data[i+1];
        }
        data[numElements-1] = null;
        numElements--;
        return removed;
    }

    public int size(){
        return numElements;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
        T[] temp = (T[]) new Object[numElements];
        for(int i = 0; i < numElements; i++){
            temp[i] = data[i];
        }
        data = (T[]) new Object[numElements * 2];
        for(int i = 0; i < numElements; i++){
            data[i] = temp[i];
        }
    }
}