class Process {
    int id;
    int burstTime;
    int priority;
    Process next;

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;

    // Add process at the end
    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        System.out.println("Process added: ID " + id);
    }

    // Remove a process by ID
    public void removeProcess(int id) {
        if (head == null) return;
        Process temp = head;
        Process prev = null;
        do {
            if (temp.id == id) {
                if (temp == head && head.next == head) {
                    head = null; // Only one node in the list
                } else if (temp == head) {
                    prev = head;
                    while (prev.next != head) prev = prev.next;
                    head = head.next;
                    prev.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Process removed: ID " + id);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Process not found: ID " + id);
    }

    // Display process list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate Round Robin scheduling
    public void roundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes available for scheduling.");
            return;
        }

        int totalTime = 0;
        Process temp = head;
        do {
            if (temp.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, temp.burstTime);
                System.out.println("Executing Process ID: " + temp.id + " for " + executionTime + " units");
                temp.burstTime -= executionTime;
                totalTime += executionTime;
                if (temp.burstTime <= 0) {
                    System.out.println("Process ID " + temp.id + " completed.");
                    removeProcess(temp.id);
                }
            }
            temp = temp.next;
        } while (head != null);

        System.out.println("Total Execution Time: " + totalTime);
    }
}

public class RoundRobinSystem {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 3);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        System.out.println("\nInitial Process List:");
        scheduler.displayProcesses();

        System.out.println("\nStarting Round Robin Scheduling:");
        scheduler.roundRobin(4);
    }
}
