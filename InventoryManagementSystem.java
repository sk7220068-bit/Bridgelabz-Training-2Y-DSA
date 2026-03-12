class InventoryManagementSystem {
    class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;
        public Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }
    private Node head = null;
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Node newNode = new Node(itemName, itemId, quantity, price);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void removeById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public void updateQuantity(int itemId, int quantity) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }
    public void search(int itemId, String itemName) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equals(itemName)) {
                System.out.println(temp.itemId + " " + temp.itemName + " " + temp.quantity + " " + temp.price);
            }
            temp = temp.next;
        }
    }
    public double calculateTotalValue() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }
    public void sortByName() {
        if (head == null || head.next == null) return;
        head = mergeSortName(head);
    }
    public void sortByPrice() {
        if (head == null || head.next == null) return;
        head = mergeSortPrice(head);
    }
    private Node mergeSortName(Node h) {
        if (h == null || h.next == null) return h;
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSortName(h);
        Node right = mergeSortName(nextOfMiddle);
        return sortedMergeName(left, right);
    }
    private Node sortedMergeName(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        Node result;
        if (a.itemName.compareTo(b.itemName) <= 0) {
            result = a;
            result.next = sortedMergeName(a.next, b);
        } else {
            result = b;
            result.next = sortedMergeName(a, b.next);
        }
        return result;
    }
    private Node mergeSortPrice(Node h) {
        if (h == null || h.next == null) return h;
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSortPrice(h);
        Node right = mergeSortPrice(nextOfMiddle);
        return sortedMergePrice(left, right);
    }
    private Node sortedMergePrice(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        Node result;
        if (a.price <= b.price) {
            result = a;
            result.next = sortedMergePrice(a.next, b);
        } else {
            result = b;
            result.next = sortedMergePrice(a, b.next);
        }
        return result;
    }
    private Node getMiddle(Node h) {
        if (h == null) return h;
        Node slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.itemId + " " + temp.itemName + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }
}
