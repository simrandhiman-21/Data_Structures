import java.util.*;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int x) {
        stack1.push(x);
        System.out.println(x + " enqueued");
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void displayQueue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i : stack2) {
            System.out.print(i + " ");
        }
        Stack<Integer> tempStack = new Stack<>();
        while (!stack1.isEmpty()) {
            tempStack.push(stack1.pop());
        }
        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.peek() + " ");
            stack1.push(tempStack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks();

        while (true) {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued: " + queue.dequeue());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println(queue.isEmpty() ? "Queue is empty" : "Queue is not empty");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
