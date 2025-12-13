public class Main {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> pq = new MinHeapPriorityQueue<>();

        int[] priorities = new int[20];
        for(int i = 0; i < priorities.length; i++){
            priorities[i] = (int)(100*Math.random()+1);
        }
        String[] values = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};

        //Checks if the minHeap is initially empty, which it should be.
        System.out.print("Initial size is empty: ");
        String result = (pq.isEmpty()) ? "PASS" : "FAIL";
        System.out.println(result);

        //Testing Insertion
        for(int i = 0; i < priorities.length; i++){
            pq.insert(priorities[i],values[i]);
        }

        //Size of pq should be 20
        System.out.print("Size correctly set: ");
        String result2 = (pq.size() == 20) ? "PASS" : "FAIL";
        System.out.println(result2);

        //Testing if the minimum of the heap is truly the highest priority.
        int minIndex = 0;
        for(int i = 0; i <  priorities.length; i++){
            if(priorities[i] < priorities[minIndex]){
                minIndex = i;
            }
        }
        PQEntry minEntry = new PQEntry(priorities[minIndex],values[minIndex]);
        System.out.print("Highest priority element is the top (minimum index) of the heap: ");
        boolean equivalentEntry = (minEntry.key().equals(pq.min().key()) && minEntry.value().equals(pq.min().value()));
        String resultM = (equivalentEntry) ? "PASS" : "FAIL";
        System.out.println(resultM);

        //The heap 'pq' should no longer be empty, and should have a length of 20.
        for(int i = 0; i < 5; i++){
            pq.removeMin();
        }

        //Size should be 15
        System.out.print("Size updated correctly: ");
        String result3 = (pq.size() == 15) ? "PASS" : "FAIL";
        System.out.println(result3);

        //The minimum entry should be returned the same for min() followed by removeMin().
        System.out.print("Minimum entry is the same for both min() and removeMin(): ");
        PQEntry min = (PQEntry) pq.min();
        PQEntry sameMin = (PQEntry) pq.removeMin();
        String result4 = (min.equals(sameMin)) ? "PASS" : "FAIL";
        System.out.println(result4);

        //Size should now be 14.
        System.out.print("Size correctly updated again (now 14): ");
        String result5 = (pq.size() == 14) ? "PASS" : "FAIL";
        System.out.println(result5);

        while(!pq.isEmpty()){
            pq.removeMin();
        }

        //Cannot remove from an empty heap (should return null and print error).
        System.out.print("Removing from Empty Heap: ");
        String resultC = (pq.removeMin() == null) ? "PASS" : "FAIL";
        System.out.println(resultC);
    }
}