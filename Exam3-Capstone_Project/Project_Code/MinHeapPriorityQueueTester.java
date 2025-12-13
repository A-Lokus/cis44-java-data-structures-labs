public class MinHeapPriorityQueueTester {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> tester = new MinHeapPriorityQueue<>();
        int[] priorities = {1,2,3,4,5,6,7,8,9,10};
        String[] values = {"A","B","C","D","E","F","G","H","I","J"};
        for(int i = 0; i < priorities.length; i++){
            tester.insert(priorities[i], values[i]);
        }

        int minIndex = 0;
        for(int i = 0; i < priorities.length; i++){
            if(priorities[i] < priorities[minIndex]){
                minIndex = priorities[i];
            }
        }
        PQEntry minEntry = new PQEntry(priorities[minIndex], values[minIndex]);

        assert tester.min().equals(minEntry);
        assert tester.removeMin().equals(minEntry);
        assert tester.insert(11, "K").equals(new PQEntry(11,"K"));
        assert !tester.isEmpty();
        assert tester.size() == 11;

    }
}