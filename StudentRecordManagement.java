class StudentRecordManagement {
    class Node {
        int rollNumber;
        String name;
        int age;
        char grade;
        Node next;
        public Node(int rollNumber, String name, int age, char grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }
    private Node head = null;
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
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
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position <= 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNumber, name, age, grade);
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return;
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public Node searchByRollNumber(int rollNumber) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
    }
    public void displayAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrade(int rollNumber, char newGrade) {
        Node student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        }
    }
}
