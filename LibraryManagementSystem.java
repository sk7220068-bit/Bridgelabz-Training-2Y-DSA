class LibraryManagementSystem {
    class Node {
        String title, author, genre, bookId;
        boolean availabilityStatus;
        Node next, prev;
        public Node(String title, String author, String genre, String bookId, boolean status) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.availabilityStatus = status;
        }
    }
    private Node head = null, tail = null;
    private int count = 0;
    public void addAtBeginning(String title, String author, String genre, String bookId, boolean status) {
        Node newNode = new Node(title, author, genre, bookId, status);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }
    public void addAtEnd(String title, String author, String genre, String bookId, boolean status) {
        Node newNode = new Node(title, author, genre, bookId, status);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }
    public void addAtPosition(int position, String title, String author, String genre, String bookId, boolean status) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, status);
            return;
        }
        Node newNode = new Node(title, author, genre, bookId, status);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp == tail) {
            addAtEnd(title, author, genre, bookId, status);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            count++;
        }
    }
    public void removeByBookId(String bookId) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId.equals(bookId)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                    else head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                count--;
                return;
            }
            temp = temp.next;
        }
    }
    public void search(String query) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equals(query) || temp.author.equals(query)) {
                System.out.println(temp.title + " " + temp.author + " " + temp.bookId);
            }
            temp = temp.next;
        }
    }
    public void updateStatus(String bookId, boolean status) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId.equals(bookId)) {
                temp.availabilityStatus = status;
                return;
            }
            temp = temp.next;
        }
    }
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.bookId + " " + temp.availabilityStatus);
            temp = temp.next;
        }
    }
    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.bookId + " " + temp.availabilityStatus);
            temp = temp.prev;
        }
    }
    public int getTotalBooks() {
        return count;
    }
}
