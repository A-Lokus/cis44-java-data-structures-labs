public class Main
{
    public static void main(String[] args)
    {
        DynamicArray<String> arrStr = new DynamicArray<String>();
        arrStr.add("a");
        arrStr.add("b");
        arrStr.add("c");
        arrStr.add("d");
        arrStr.add("e");
        System.out.println("String array size: "+arrStr.size());
        for(int i = 0; i < arrStr.size(); i++){
            System.out.print(arrStr.get(i)+" ");
        }
        System.out.println();
        System.out.println("Removed element at index 1: "+arrStr.remove(1));
        System.out.println("New size: "+arrStr.size());
        for(int i = 0; i < arrStr.size(); i++){
            System.out.print(arrStr.get(i)+" ");
        }
        System.out.println();
        DynamicArray<Integer> arrInt = new DynamicArray<Integer>();
        for(int i = 0; i < 20; i++){
            arrInt.add(i+1);
        }
        System.out.println();
        System.out.println("Integer array size: "+arrInt.size());
        for(int i = 0; i < arrInt.size(); i++){
            System.out.print(arrInt.get(i)+" ");
        }
        System.out.println();
        System.out.println("Removing odd numbers...");
        for(int i = 0; i < arrInt.size(); i++){
            if(arrInt.get(i)%2!=0){
                arrInt.remove(i);
                i--;
            }
        }
        System.out.println("New size: "+arrInt.size());
        for(int i = 0; i < arrInt.size(); i++){
            System.out.print(arrInt.get(i)+" ");
        }
    }
}