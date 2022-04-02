package topic1.stack;

public class Q2StackUsingLinkedList {

    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void push(int data)
    {
        if(head == null)
            head = new Node(data);
        else
        {
            Node oldHead = head;
            head = new Node(data);
            head.next = oldHead;
        }
        System.out.println("Pushed :: " + data);
    }

    public int pop()
    {
        if (head == null) {
            System.out.println("Stack is Empty");
            return 0;
        }
        int value = head.data;
        head = head.next;
        System.out.println("Pop :: " + value);
        return value;
    }

    public void printStack()
    {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q2StackUsingLinkedList s = new Q2StackUsingLinkedList();
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
