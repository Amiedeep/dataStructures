import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingTwoStacks(Stack<Integer> enqueueStack, Stack<Integer> dequeueStack) {
        this.enqueueStack = enqueueStack;
        this.dequeueStack = dequeueStack;
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks(new Stack<Integer>(), new Stack<Integer>());
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String[] operation = scanner.nextLine().split(" ");
            int operationCommand = Integer.parseInt(operation[0]);
            if (operationCommand == 1)
                queueUsingTwoStacks.enqueue(Integer.parseInt(operation[1]));
            else if (operationCommand == 2)
                queueUsingTwoStacks.dequeue();
            else if (operationCommand == 3)
                queueUsingTwoStacks.peek();
        }
    }

    private void peek() {
        copyStackIfEmpty(enqueueStack, dequeueStack);
        System.out.println(dequeueStack.peek());
    }

    private void dequeue() {
        copyStackIfEmpty(enqueueStack, dequeueStack);
        dequeueStack.pop();
    }

    private void enqueue(int value) {
        enqueueStack.push(value);
    }

    private void copyStackIfEmpty(Stack<Integer> source, Stack<Integer> destination) {
        if (destination.empty()) {
            while(!source.empty()) {
                int element = source.pop();
                destination.push(element);
            }
        }
    }
}
