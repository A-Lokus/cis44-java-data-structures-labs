public class TextEditor {
    private static class Node{
        String textState;
        Node prev;
        Node next;

        public Node(String t, Node p, Node n){
            textState = t;
            prev = p;
            next = n;
        }
    }

    private Node currentNode;

    public TextEditor(){
        Node initialState = new Node("", null, null);
        currentNode = initialState;
    }

    public void add(String newText){
        String updTxt = currentNode.textState + newText;
        Node updated = new Node(updTxt, currentNode, null);
        currentNode.next = updated;
        currentNode = updated;
    }
    public String undo(){
        if(currentNode.prev != null){
            currentNode = currentNode.prev;
            return currentNode.textState;
        }
        else{
            System.out.println("Error: Cannot undo action");
            return "";
        }
    }
    public String redo(){
        if(currentNode.next != null){
            currentNode = currentNode.next;
            return currentNode.textState;
        }
        else{
            System.out.println("Error: Cannot redo action");
            return "";
        }
    }
    public void printCurrent(){
        System.out.println(currentNode.textState);
    }
}