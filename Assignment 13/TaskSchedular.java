class TaskScheduler {
    Node head, tail;

    class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = this;
        }
    }

    public void addFirst(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }

    public void addLast(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position == 1) {
            addFirst(taskId, taskName, priority, dueDate);
            return;
        }
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        Node currNode = head;
        for (int i = 1; i < position - 1 && currNode.next != head; i++) {
            currNode = currNode.next;
        }
        if (currNode.next == head) {
            addLast(taskId, taskName, priority, dueDate);
        } else {
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
    }

    public void delete(int taskId) {
        if (head == null) {
            return;
        }
        if (head.taskId == taskId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        Node currNode = head;
        while (currNode.next != head && currNode.next.taskId != taskId) {
            currNode = currNode.next;
        }
        if (currNode.next.taskId == taskId) {
            if (currNode.next == tail) {
                tail = currNode;
            }
            currNode.next = currNode.next.next;
        }
    }

    public void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task: " + head.taskName + " (ID: " + head.taskId + ", Priority: " + head.priority + ", Due: " + head.dueDate + ")");
        }
    }

    public void moveToNextTask() {
        if (head != null) {
            head = head.next;
        }
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node currNode = head;
        do {
            System.out.println(currNode.taskName + " (ID: " + currNode.taskId + ", Priority: " + currNode.priority + ", Due: " + currNode.dueDate + ")");
            currNode = currNode.next;
        } while (currNode != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            return;
        }
        Node currNode = head;
        boolean found = false;
        do {
            if (currNode.priority == priority) {
                System.out.println("Task Found: " + currNode.taskName + " (ID: " + currNode.taskId + ", Due: " + currNode.dueDate + ")");
                found = true;
            }
            currNode = currNode.next;
        } while (currNode != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addFirst(1, "Task A", 2, "2025-02-15");
        ts.addLast(2, "Task B", 1, "2025-02-18");
        ts.addAtPosition(3, "Task C", 3, "2025-02-20", 2);
        ts.display();
        ts.viewCurrentTask();
        ts.moveToNextTask();
        ts.viewCurrentTask();
        ts.searchByPriority(1);
        ts.delete(2);
        ts.display();
    }
}
