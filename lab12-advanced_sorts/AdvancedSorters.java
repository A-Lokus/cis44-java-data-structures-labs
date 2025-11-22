import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSorters {

    // --- MergeSort ---
    public static <K> void mergeSort(K[] S, Comparator comp) {
        int n = S.length;
        if (n < 2) return; // Base case

        //Divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        //Conquer (recursive calls)
        mergeSort(S1, comp);
        mergeSort(S2, comp);


        merge(S, S1, S2, comp);
    }

    private static <K> void merge(K[] S, K[] S1, K[] S2, Comparator comp) {
        int i = 0, j = 0;

        while (i+j < S.length){
            if(j == S2.length || (i != S1.length && comp.compare(S1[i], S2[j]) <= 0)){
                S[i+j] = S1[i++];
            }
            else{
                S[i+j] = S2[j++];
            }
        }
    }

    // --- QuickSort ---
    public static <K> void quickSort(K[] S, Comparator comp) {
        quickSort(S, comp, 0, S.length - 1);
    }

    private static <K> void quickSort(K[] S, Comparator comp, int a, int b) {
        if (a >= b) return; // Base case


        int pivotIndex = partition(S, comp, a, b);


        quickSort(S, comp, a, pivotIndex - 1);
        quickSort(S, comp, pivotIndex + 1, b);
    }

    private static <K> int partition(K[] S, Comparator comp, int a, int b) {
        int pivotIndex = (int)(Math.random() * (b - a + 1)) + a;

        K pivot = S[pivotIndex];

        K temp = S[b];
        S[b] = S[pivotIndex];
        S[pivotIndex] = temp;

        int left = a;
        int right = b-1;
        while(left <= right){
            while(left <= right && comp.compare(S[left], pivot) < 0){
                left++;
            }
            while(left <= right && comp.compare(S[right], pivot) > 0){
                right--;
            }

            if(left <= right){
                K temp2 = S[left];
                S[left] = S[right];
                S[right] = temp2;
                left++;
                right--;
            }
        }

        K temp3 = S[b];
        S[b] = S[left];
        S[left] = temp3;

        return left; // placeholder
    }
}
