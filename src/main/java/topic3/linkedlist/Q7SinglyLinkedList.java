package topic3.linkedlist;
public class Q7SinglyLinkedList {

    class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void addAtFirst(int data)
    {
        Node n = new Node(data);
        if(head == null)
            head = n;
        else
        {
            Node temp = head;
            n.next = temp;
            head = n;
        }
    }

    public void addAtLast(int data)
    {
        Node n = new Node(data);
        if(head == null)
            head = n;
        else
        {
            Node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public void printLinkedList(Node node)
    {
        Node temp = node;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeAfterNode(int data)
    {
        if(head == null)
        {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp.next !=null && temp.data != data)
        {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void removeAtFirst()
    {
        head = head.next;
    }

    public Node reverse()
    {
        Node previousNode=null;
        Node nextNode;
        while(head!=null)
        {
            nextNode=head.next;
            // reversing the link
            head.next=previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode=head;
            head=nextNode;
        }
        head = previousNode;
        return previousNode;
        // a -> b -> c
        // c -> b -> a
    }

    public void findMiddleElement()
    {
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer !=null) {
            fastPointer = fastPointer.next;
            if(fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }
        System.out.println("Middle Element :: " + slowPointer.data);
    }

    public static void main(String[] args) {
        Q7SinglyLinkedList s = new Q7SinglyLinkedList();
        s.removeAfterNode(1);
        s.addAtFirst(1);
        s.addAtLast(2);
        s.addAtFirst(3);
        s.printLinkedList(s.head);
        s.removeAfterNode(1);
        s.printLinkedList(s.head);
        s.addAtLast(4);
        s.addAtLast(5);
        s.addAtLast(9);
        s.addAtLast(6);
        s.removeAfterNode(4);
        s.addAtLast(7);
        s.printLinkedList(s.head);
        s.removeAtFirst();
        s.printLinkedList(s.head);
        Node temp = s.reverse();
        System.out.print("Reversed :: ");
        s.printLinkedList(temp);
        s.findMiddleElement();
    }
}
