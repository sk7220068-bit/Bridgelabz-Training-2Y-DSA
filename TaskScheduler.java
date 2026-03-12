class TaskScheduler {
    class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;
        public Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }
    private Node head = null;
    private Node current = null;
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void removeByTaskId(int taskId) {
        if (head == null) return;
        Node temp = head;
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
                current = null;
                return;
            }
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            if (current != null && current.taskId == taskId) current = head;
            return;
        }
        temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next.taskId == taskId) {
            if (current == temp.next) current = temp.next.next;
            temp.next = temp.next.next;
        }
    }
    public void viewCurrentAndMove() {
        if (current != null) {
            System.out.println(current.taskId + " " + current.taskName);
            current = current.next;
        }
    }
    public void displayAll() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchByPriority(int priority) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskId + " " + temp.taskName);
            }
            temp = temp.next;
        } while (temp != head);
    }
}
