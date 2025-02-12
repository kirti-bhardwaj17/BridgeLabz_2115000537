import java.util.*;

class RoundRobinSchedular {
    class Process {
        int processId, burstTime, priority;
        Process next;

        Process(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private Process head, tail;
    private int timeQuantum;

    public RoundRobinSchedular(int timeQuantum) {
        this.head = this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;
        Process current = head, prev = null;
        do {
            if (current.processId == processId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void simulateRoundRobin() {
        if (head == null) return;
        int time = 0;
        Queue<Process> queue = new LinkedList<>();
        Process current = head;

        do {
            queue.add(new Process(current.processId, current.burstTime, current.priority));
            current = current.next;
        } while (current != head);

        int[] waitingTime = new int[queue.size()];
        int[] turnaroundTime = new int[queue.size()];
        int completedProcesses = 0;

        while (!queue.isEmpty()) {
            Process p = queue.poll();
            int processIndex = completedProcesses++;

            waitingTime[processIndex] = time;
            if (p.burstTime > timeQuantum) {
                time += timeQuantum;
                p.burstTime -= timeQuantum;
                queue.add(p);
            } else {
                time += p.burstTime;
                turnaroundTime[processIndex] = time;
            }
            displayProcesses(queue);
        }

        calculateAvgTimes(waitingTime, turnaroundTime, completedProcesses);
    }

    private void displayProcesses(Queue<Process> queue) {
        for (Process p : queue) {
            System.out.println("Process ID: " + p.processId + ", Burst Time: " + p.burstTime + ", Priority: " + p.priority);
        }
        System.out.println();
    }

    private void calculateAvgTimes(int[] waitingTime, int[] turnaroundTime, int count) {
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (int i = 0; i < count; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / count));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / count));
    }

    public static void main(String[] args) {
        RoundRobinSchedular scheduler = new RoundRobinSchedular(4);
        scheduler.addProcess(1, 8, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 10, 3);
        scheduler.addProcess(4, 6, 2);
        scheduler.simulateRoundRobin();
    }
}
