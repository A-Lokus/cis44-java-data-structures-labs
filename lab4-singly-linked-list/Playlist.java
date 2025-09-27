public class Playlist {
    private static class Node{
        Song song;
        Node next;

        public Node(Song s, Node n){
            song = s;
            next = n;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist(){
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void addSong(Song s){
        Node newSong = new Node(s,null);
        if(isEmpty()){
            head = newSong;
        }
        else{
            tail.next = newSong;
        }
        tail = newSong;
        size++;
    }

    public void removeSong(String title){
        boolean songFound = false;

        if(head.song.getTitle().equalsIgnoreCase(title)){
            head = head.next;
            songFound = true;
        }
        else{
            Node prev = head;
            Node curr = head.next;
            int index = -1;
            for(int i = 1; i < size(); i++){
                if(curr.song.getTitle().equalsIgnoreCase(title)){
                    index = i;
                    i = size();
                }
                else{
                    curr = curr.next;
                    prev = prev.next;
                }
            }
            if(index < 0){
                System.out.println("Error: Song not found");
            }
            else if(curr.equals(tail)){
                tail = prev;
                tail.next = null;
                songFound = true;
            }
            else{
                prev.next = curr.next;
                songFound = true;
            }
        }
        if(currentNode != null && currentNode.song.getTitle().equalsIgnoreCase(title)){
            currentNode = null;
        }
        if(songFound){size--;}
        if(size == 0){
            tail = null;
        }
    }

    public void playNext(){
        if(currentNode == null || currentNode.equals(tail)){currentNode = head;}
        else{
            currentNode = currentNode.next;
        }
        System.out.println("Now playing: "+currentNode.song);
    }

    public void displayPlaylist(){
        if(size == 0){System.out.println("Playlist is empty");}
        else {
            System.out.println("Playlist:");
            Node curr = head;
            for (int i = 0; i < size(); i++) {
                System.out.println(curr.song);
                curr = curr.next;
            }
        }
    }
}