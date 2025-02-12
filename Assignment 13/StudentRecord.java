class StudentRecord {
    Node head;

    class Node {
        int rollNum;
        String name;
        int age;
        char grade;
        Node next;

        Node(int rollNum, String name, int age, char grade) {
            this.rollNum = rollNum;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    public void addFirst(int rollNum, String name, int age, char grade) {
        Node newNode = new Node(rollNum, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int rollNum, String name, int age, char grade) {
        Node newNode = new Node(rollNum, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void addAtPosition(int rollNum, String name, int age, char grade, int position) {
        if (position == 1) {
            addFirst(rollNum, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNum, name, age, grade);
        Node currNode = head;
        for (int i = 1; i < position - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }
        if (currNode == null) {
            System.out.println("Position out of range!");
            return;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void delete(int rollNum) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNum == rollNum) {
            head = head.next;
            return;
        }
        Node currNode = head;
        while (currNode.next != null && currNode.next.rollNum != rollNum) {
            currNode = currNode.next;
        }
        if (currNode.next == null) {
            System.out.println("Roll number not found");
            return;
        }
        currNode.next = currNode.next.next;
    }

    public void search(int rollNum) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.rollNum == rollNum) {
                System.out.println("Student Found: " + currNode.name + " " + currNode.rollNum + " Age: " + currNode.age + " Grade: " + currNode.grade);
                return;
            }
            currNode = currNode.next;
        }
        System.out.println("Student not found!");
    }

    public void updateGrade(int rollNum, char newGrade) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.rollNum == rollNum) {
                currNode.grade = newGrade;
                System.out.println("Grade updated successfully!");
                return;
            }
            currNode = currNode.next;
        }
        System.out.println("Student not found");
    }

    public void display() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }
        Node currNode = head;
        System.out.println("Student Records:");
        while (currNode != null) {
            System.out.println(currNode.rollNum + " - " + currNode.name + ", Age: " + currNode.age + ", Grade: " + currNode.grade);
            currNode = currNode.next;
        }
    }

    public static void main(String args[]) {
        StudentRecord sr = new StudentRecord();
        sr.addFirst(11, "Alice", 20, 'A');
        sr.addLast(13, "Bob", 21, 'B');
        sr.addAtPosition(12, "Kiara", 21, 'C', 2);
        sr.display();
        sr.updateGrade(13, 'A');
        sr.delete(11);
        sr.display();
    }
}
