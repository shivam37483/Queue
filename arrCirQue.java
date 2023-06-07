package queue;

public class arrCirQue {
    public static class Circular {
        int [] arr;
        int begQ;
        int topQ;

        public Circular(int size){
            arr = new int[size];
            begQ = -1;
            topQ = -1;
        }

        public boolean isEmpty() {
            if (topQ == -1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFull() {
            if (topQ == arr.length -1 && begQ == 0) {
                return true;
            } else if(topQ +1 == begQ) {
                return true;
            } else{
                return false;
            }
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("queue is full");
            } else if (isEmpty()) {
                begQ = 0;
                topQ++;
                arr[topQ] = value;
                System.out.println("added: " + value);
            } else{
                if (topQ == arr.length -1) {
                    topQ = 0;
                } else {
                    topQ++;                    
                }

                arr[topQ] = value;
                System.out.println("added: " + value);
            }
        }

        public int deQueue() {
            if (isEmpty()) {
                System.out.println("que is empty");
                return -2;
            } else {
                int ret = arr[begQ];
                arr[begQ] = Integer.MIN_VALUE;
                
                if (begQ == topQ) {
                    begQ = topQ = -1;
                } else if(begQ == arr.length -1) {
                    begQ = 0;
                } else{
                    begQ++;
                }
                return ret;
            }
        }

        public void peek() {
            if (isEmpty()) {
                System.out.println("empyt");
            } else {
                System.out.println(arr[topQ]);
            }
        }

        public void show() {
            for (int i = begQ; i <= topQ; i++) {
                System.out.print(arr[i] + " ");
            }
        }

    }   
        public static void main(String[] args) {
            Circular one = new Circular(3);
            one.enqueue(1);
            one.enqueue(1);
            one.enqueue(1);
            one.enqueue(1);

            System.out.println(one.deQueue());
            System.out.println(one.deQueue());
            System.out.println(one.deQueue());
            System.out.println(one.deQueue());
        }
        
}
