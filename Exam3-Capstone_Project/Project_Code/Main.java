public class Main {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> pq = new MinHeapPriorityQueue<>();

        int[] priorities = {7, 1, 2, 4, 9, 12, 82, 3, 72, 81};
        String[] values = {"Seven", "One","Two","Four","Nine","Twelve","task 82", "Three", "Task 72", "task 81"};

        for(int i = 0; i < priorities.length; i++){
            pq.insert(priorities[i],values[i]);
        }
        while(!pq.isEmpty()){
            System.out.println(pq.removeMin());
        }
    }
}