import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {
    public static void main(String[] args) {
        Comparator comp = Comparator.naturalOrder();
        int N = 100;
        Random rand = new Random();

        Integer[] arr1 = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(100);
        }
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=100) ---");
        System.out.println("Original: ");
        printArrayInSubsets(arr1, 25);
        System.out.println("\n");

        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort: ");
        printArrayInSubsets(arr1, 25);
        System.out.println("\n");

        System.out.println("Original: ");
        printArrayInSubsets(arr2, 25);
        System.out.println("\n");
        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort: ");
        printArrayInSubsets(arr2, 25);
        System.out.println("\n");
    }

    public static <K> void printArrayInSubsets(K[] arr, int subsetWidth){
        for(int i = 0; i < arr.length ; i++) {
            if(i % subsetWidth == 0){
                int endBound = i+subsetWidth;
                if(arr.length - i < subsetWidth){
                    endBound = arr.length;
                }
                if(i != 0) {
                    System.out.println();
                }
                System.out.print("(" + (i+1) + " - " + (endBound) + "): [");

            }
            if((i+1) % subsetWidth == 0 && i != 0 || (arr.length - i < subsetWidth && i == arr.length-1)){
                System.out.print(arr[i] + "]");
            }
            else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
}