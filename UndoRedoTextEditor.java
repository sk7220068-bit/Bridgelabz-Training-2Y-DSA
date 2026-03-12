class UndoRedoTextEditor {
    class Node {
        String textState;
        Node next, prev;
        public Node(String textState) {
            this.textState = textState;
        }
    }
    private Node head = null;
    private Node current = null;
    private int size = 0;
    private final int MAX_SIZE = 10;
    public void addState(String textState) {
        Node newNode = new Node(textState);
        if (head == null) {
            head = current = newNode;
            size++;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            size++;
            if (size > MAX_SIZE) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }
    public void displayCurrentState() {
        if (current != null) {
            System.out.println(current.textState);
        }
    }
}
