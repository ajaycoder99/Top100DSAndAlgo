package topic1.stack;

import java.util.LinkedList;
import java.util.Queue;
/*
Push :
If queue1 is empty, add elements to queue1
If queue1 is not empty, add all elements of queue1 to queue2 ,
   add current element to queue1 and copy all elements of queue2 to queue1.

Pop : Simply remove element from queue1.
*/
public class Q3StackUsingQueues {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public Q3StackUsingQueues()
    {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public void push(int i){
        if(queue1.size()==0)
            queue1.add(i);
        else{
            int sizeOfQueue1 = queue1.size();

            // Copy elements of Queue1 to Queue2
            for(int j=0 ; j<sizeOfQueue1 ; j++)
                queue2.add(queue1.remove());

            queue1.add(i);

            // Copy elements for Queue2 to Queue1
            for(int k=0 ; k<sizeOfQueue1 ; k++)
                queue1.add(queue2.remove());
        }
        System.out.println("Push :: " + i);
    }

    public int pop(){
        if(queue1.size()==0)
        {
            System.out.println("Stack is Empty");
            return 0;
        }

        System.out.println("Pop :: " + queue1.peek());
        return queue1.remove();
    }

    public void printStack()
    {
        queue1.forEach(p -> System.out.print(p+" "));
        System.out.println();
    }

    public static void main(String[] args) {
        Q3StackUsingQueues s = new Q3StackUsingQueues();
        s.pop();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.printStack();
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(6);
        s.pop();
        s.push(7);
        s.printStack();

    }
}
