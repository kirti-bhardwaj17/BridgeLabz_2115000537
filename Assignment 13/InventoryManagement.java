class InventoryManagement {
    Node head;

    class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    public void addFirst(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
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

    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position == 1) {
            addFirst(itemName, itemId, quantity, price);
            return;
        }
        Node newNode = new Node(itemName, itemId, quantity, price);
        Node currNode = head;
        for (int i = 1; i < position - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }
        if (currNode == null) {
            return;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }

    public void delete(int itemId) {
        if (head == null) {
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Node currNode = head;
        while (currNode.next != null && currNode.next.itemId != itemId) {
            currNode = currNode.next;
        }
        if (currNode.next == null) {
            return;
        }
        currNode.next = currNode.next.next;
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.itemId == itemId) {
                currNode.quantity = newQuantity;
                return;
            }
            currNode = currNode.next;
        }
    }

    public void searchById(int itemId) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.itemId == itemId) {
                System.out.println("Item Found: " + currNode.itemName + " (ID: " + currNode.itemId + ", Quantity: " + currNode.quantity + ", Price: " + currNode.price + ")");
                return;
            }
            currNode = currNode.next;
        }
    }

    public void searchByName(String itemName) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.itemName.equals(itemName)) {
                System.out.println("Item Found: " + currNode.itemName + " (ID: " + currNode.itemId + ", Quantity: " + currNode.quantity + ", Price: " + currNode.price + ")");
                return;
            }
            currNode = currNode.next;
        }
    }

    public double totalInventoryValue() {
        double totalValue = 0;
        Node currNode = head;
        while (currNode != null) {
            totalValue += currNode.quantity * currNode.price;
            currNode = currNode.next;
        }
        return totalValue;
    }

    public void sortByNameAscending() {
        head = mergeSort(head, true);
    }

    public void sortByPriceDescending() {
        head = mergeSort(head, false);
    }

    private Node mergeSort(Node head, boolean sortByName) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head, sortByName);
        Node right = mergeSort(nextToMiddle, sortByName);
        return merge(left, right, sortByName);
    }

    private Node merge(Node left, Node right, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;
        if ((sortByName && left.itemName.compareTo(right.itemName) < 0) || (!sortByName && left.price > right.price)) {
            left.next = merge(left.next, right, sortByName);
            return left;
        } else {
            right.next = merge(left, right.next, sortByName);
            return right;
        }
    }

    private Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void display() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.itemName + " (ID: " + currNode.itemId + ", Quantity: " + currNode.quantity + ", Price: " + currNode.price + ")");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();
        im.addFirst("Laptop", 101, 5, 700.0);
        im.addLast("Mouse", 102, 10, 20.0);
        im.addAtPosition("Keyboard", 103, 8, 50.0, 2);
        im.display();
        System.out.println("Total Inventory Value: " + im.totalInventoryValue());
        im.sortByNameAscending();
        im.display();
        im.sortByPriceDescending();
        im.display();
    }
}
