package topic3.linkedlist;

import java.sql.SQLOutput;

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

    public void addAtLastWithLoop(int data)
    {
        Node n = new Node(data);
        n.next = head.next.next;
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

    public Node reverse(Node node)
    {
        Node previousNode=null;
        Node nextNode;
        while(node!=null)
        {
            nextNode=node.next;
            // reversing the link
            node.next=previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode=node;
            node=nextNode;
        }
        head = previousNode;
        return previousNode;
        // a -> b -> c
        // c -> b -> a
    }

    public Node findMiddleElement()
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
        return slowPointer;
    }

    /*
    Efficient approach for this problem would be Floyd’s cycle detection algorithm,so steps for this algo would be:
    Use two pointer fastPtr and slowPtr and initialize both to head of linkedlist
    Move fastPtr by two nodes and slowPtr by one node in each iteration.
    If fastPtr and slowPtr meet at some iteration , then there is a loop in linkedlist.
    If fastPtr reaches to the end of linkedlist without meeting slow pointer then there is no loop in linkedlist (i.e fastPtr->next or fastPtr->next->next become null)
     */
    public boolean detectLoop()
    {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    /*
    It is quite easy to find starting node of loop in linkedlist.

    Find meeting point of slowPointer and fastPointer.
    set slowPointer to head node of linkedlist.
    Move slowPointer and fastPointer both by one node.
    The node at which slowPointer and fastPointer meets, will be starting node of loop.
     */
    public Node findStartOfLoop()
    {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists=false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
            {
                loopExists=true;
                break;
            }

        }
        if(loopExists)
        {
            slowPtr=head;

            while(slowPtr!=fastPtr)
            {
                slowPtr=slowPtr.next;
                fastPtr=fastPtr.next;
            }

        }
        else
        {
            System.out.println("Loop does not exists");
            slowPtr=null;
        }
        return slowPtr;
    }

    // Function to check if linked list is palindrome or not
    public boolean checkPalindrome (Node head)
    {
        // Find middle node using slow and fast pointer
        Node middleNode=findMiddleElement();
        // we got head of second part
        Node secondHead=middleNode.next;
        // It is end of first part of linked list
        middleNode.next=null;
        // get reversed linked list for second part
        Node reverseSecondHead=reverse(secondHead);

        while(head!=null && reverseSecondHead!=null)
        {
            if(head.data==reverseSecondHead.data)
            {
                head=head.next;
                reverseSecondHead=reverseSecondHead.next;
                continue;
            }
            else
            {
                return false;
            }
        }

        return true;

    }

    /*
    Here is simple algorithm to find Intersection of two linked lists.
    Find the length of both singly linked lists.
    Find the bigger linked list and iterate up to the difference between two linked list.
    Please note that two linked list will become equal at this step.
    Iterate over both linked list and check if there is any common node, if you find one, return it.
    Else return null.
     */

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
        s.findMiddleElement();
        s.removeAtFirst();
        s.printLinkedList(s.head);
        Node temp = s.reverse(s.head);
        System.out.print("Reversed :: ");
        s.printLinkedList(temp);
        s.findMiddleElement();
        //s.addAtLastWithLoop(9);
        //System.out.println("Loop in LinkedList :: " + s.detectLoop());
        //System.out.println("Start of Loop :: " + s.findStartOfLoop().data);
        s.removeAfterNode(9);
        s.removeAfterNode(9);
        s.addAtLast(6);
        s.addAtLast(7);
        s.printLinkedList(s.head);
        System.out.println("Palindrome :: " + s.checkPalindrome(s.head));
    }
}
