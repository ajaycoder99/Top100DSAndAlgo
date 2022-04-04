package topic2.queue;

public class Q5QueueUsingArray {

    int[] arr;
    int size;
    int capacity;

    public Q5QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public void enQueue(int data){
        if(size < capacity)
            arr[size++] = data;
        else
            System.out.println("Queue is full");
    }

    public int deQueue(){
        int x = arr[0];
        if(size == 0) {
            System.out.println("Queue is Empty");
            return 0;
        }
        else
        {
            for(int i = 1 ; i < size ; i++)
            {
                arr[i-1] = arr[i];
            }
        }
        arr[--size] = 0;
        return x;
    }

    public void printQueue()
    {
        int i = size-1;
        while(i!=0)
        {
            System.out.print(arr[i]+" ");
            i--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q5QueueUsingArray q = new Q5QueueUsingArray(5);
        q.deQueue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.deQueue();
        q.printQueue();
        q.enQueue(4);
        q.enQueue(5);
        q.enQueue(6);
        q.enQueue(6);
        q.deQueue();
        q.enQueue(7);
        q.printQueue();
        q.deQueue();
        q.printQueue();
    }
}
