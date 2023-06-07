public class linkQue {
    public static class Node {
        int value;
        Node next;        
    } 

    public static class Link {
        int size;
        Node head;
        Node tail;

        public Link(){
            size = 0;
            head = new Node();
            head.next = null;
        }

        
        
    }
}
