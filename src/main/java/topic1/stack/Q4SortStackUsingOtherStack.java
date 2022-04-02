package topic1.stack;

import java.util.Stack;

public class Q4SortStackUsingOtherStack {

    public Stack<Integer> sortStack(Stack<Integer> stack)
    {
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty())
        {
            int currentData=stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > currentData) {
                stack.push(tempStack.pop());
            }
            tempStack.push(currentData);
        }
        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.push(5);

        Q4SortStackUsingOtherStack test = new Q4SortStackUsingOtherStack();
        Stack<Integer> sortedStack = test.sortStack(stack);
        sortedStack.forEach(p -> System.out.print(p + " "));
    }

}
