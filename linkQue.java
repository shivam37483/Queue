package queue;

public class linkQue {
    public static class Node {
        int value;
        Node next;        
    } 

    public static class List{
        Node head;
        Node tail;
        int size =0;

        public void create(int val) {
            Node one = new Node();
            one.value = val;
            one.next = null;

            head = one;
            tail = one;

            size++;
        }

        public void show() {
            Node one = head;

            while (one != null) {
                System.out.print(one.value + " -> ");
                one = one.next; 
            }

            System.out.println("null");
        }

        public void insert(int val, int location) {
            Node one = new Node();
            one.value = val;
        
            if (location == 1) {
                if (head == null) {
                    create(val);
                    return;
                }
                one.next = head;
                head = one; 
                size++;                
            } else if(location == size + 1) { // Change this condition
                tail.next = one;
                tail = one; 
                tail.next = null;
                size++;                
            } else if(size >= location) {
                throw new IllegalArgumentException("size greater than location");
            } else {
                Node two = head;
                int cot = 0;
        
                while (cot != location - 1) {
                    two = two.next;
                    cot++;
                }
        
                one.next = two.next;
                two.next = one;
                size++;
            }
        }

        public void search(int nodeValue) {
            Node node = head;
            int count = 0;

            while (node != null) {
                if (node.value == nodeValue) {
                    System.out.println("value present at " + count);
                    return;
                }

                count++;
                node = node.next;
            }

            System.out.println("value not present");
        }

        public void del(int location) {
            if (head == null) {
                System.out.println("List does not exist");
            } else if (size ==1) {
                head = null;
                tail = null;
                size--;
            } else{
                Node one = head;

                if (location == 0) {
                    head = head.next;
                    size--;
                }
                
                else if (location >= size) {
                    while (one.next != tail) {
                        one = one.next; 
                    }

                    one.next = null;
                    tail = one;
                    size--;
                }

                else{
                    int index = 0;

                    while (index != location -1) {
                        one = one.next; 
                        index++;
                    }

                    one.next = one.next.next;
                    size--;
                }                
            }                
        }
    }

    public static class Que{
        int size;
        int limit;
        Node topQ;
        Node begQ;
        List one;

        public Que(int val){
            one = new List();  
            size = 0;
            limit = val;
        }

        public boolean isEmpty() {
            if (topQ == null) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFull() {
            if (size == limit) {
                return true;
            } else {
                return false;
            }
        }
        public void enQueue(int val) {
            if (isEmpty()) {
                one.create(val);
                size++;
                topQ = one.head;
                begQ = one.tail;
            } else if (isFull()) {
                System.out.println("full");
            } else {
                size++;
                one.insert(val,size);
                topQ = one.tail;
            }
        }

        public int deQueue() {
            if (isEmpty()) {
                throw new IllegalStateException("que is empty");
            }

            int ret = begQ.value;
            one.head = one.head.next;
            begQ = one.head;

            if (begQ == null) {
                topQ = null;
            }

            return ret;            
        }


        public void show() {
            one.show();
        }
        
        public int peek() {
            return begQ.value;
        }
    }

    public static void main(String[] args) {
        Que one = new Que(5);

        one.enQueue(0);
        one.enQueue(7);
        one.enQueue(2);
        one.enQueue(3);

        one.show();

        one.deQueue();
        one.deQueue();
        one.deQueue();

        one.show();
    }
 
}
