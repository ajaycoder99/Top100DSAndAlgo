package topic1.stack;

public class Q1StackUsingArray {

    int arr[];
    int capacity;
    int size;

    public Q1StackUsingArray(int capacity)
    {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size=0;
    }

    public Q1StackUsingArray()
    {
        capacity = 16;
        size=0;
        arr = new int[capacity];
    }

    public void push(int data)
    {
        if(size < capacity)
        {
            arr[size++] = data;
            System.out.println("Pushed :: " + data);
        }
        else
            System.out.println("Stack is Full");
    }

    public int pop()
    {
        if(size > 0)
        {
            System.out.println("Pop :: " + arr[size-1]);
            return arr[--size];
        }
        else
        {
            System.out.println("Stack is Empty");
            return 0;
        }
    }

    public void printStack()
    {
        if(size > 0)
        {
            int i = size;
            while(i!=0)
                System.out.print(" " + arr[--i]);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Q1StackUsingArray stackUsingArray = new Q1StackUsingArray(5);
        stackUsingArray.pop();
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        stackUsingArray.push(3);
        stackUsingArray.pop();
        stackUsingArray.printStack();
        stackUsingArray.push(4);
        stackUsingArray.push(5);
        stackUsingArray.push(6);
        stackUsingArray.push(6);
        stackUsingArray.pop();
        stackUsingArray.push(7);
        stackUsingArray.printStack();
    }

}
