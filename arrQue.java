package queue;

public class arrQue {
    public static class queue {
        int[] arr;
        int botQ;
        int topQ;

        public queue(int size){
            this.arr = new int[size];
            this.botQ = -1;
            this.topQ = -1;
        }

        public void enqueue(int val) {
            if (isFull()) {
                System.out.println("que full");
                return;
            } else if (isEmpty()) { //if (topQ == -1) {
                    topQ++;
                    botQ++;
                    arr[topQ] = val;
                    
                } else {
                    topQ++;
                    arr[topQ] = val;                  
            }
        }

        public int deque() {
            if (isEmpty()) {
                throw new IllegalStateException("que empty");
            } else {
                int ret = arr[botQ];
                botQ++;
                if (botQ > topQ) {
                    botQ = topQ = -1;
                }
                return ret;

            }
        }

        public void show() {
            for (int i = botQ; i <= topQ ; i++) {
                System.out.println(arr[i]);
            }
        }

        public boolean isFull() {
            if (topQ == arr.length -1) {
                return true;
            } else{   
                return false;
            }
        }
        
        public boolean isEmpty() {
            if (botQ == -1 || botQ == arr.length) {
                return true;                
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        queue one = new queue(5);

        one.enqueue(0);
        one.enqueue(2);
        one.enqueue(1);
        one.enqueue(4);
        one.enqueue(5);

        one.show();

        one.deque();
        one.deque();
        System.out.println();
        one.show();
        System.out.println(one.isFull());

    }
}
