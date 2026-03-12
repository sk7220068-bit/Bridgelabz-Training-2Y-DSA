class RoundRobinSchedulingAlgorithm {
    class Node {
        int processId;
        int burstTime;
        int remainingBurstTime;
        int priority;
        int waitingTime;
        int turnAroundTime;
        Node next;
        public Node(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.remainingBurstTime = burstTime;
            this.priority = priority;
            this.waitingTime = 0;
            this.turnAroundTime = 0;
        }
    }
    private Node head = null;
    private Node tail = null;
    private java.util.List<Node> completedProcesses = new java.util.ArrayList<>();
    public void addProcess(int processId, int burstTime, int priority) {
        Node newNode = new Node(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void removeProcess(int processId) {
        if (head == null) return;
        if (head == tail && head.processId == processId) {
            head = tail = null;
            return;
        }
        Node temp = head, prev = tail;
        do {
            if (temp.processId == processId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    public void simulate(int timeQuantum) {
        if (head == null) return;
        int currentTime = 0;
        Node temp = head;
        Node prev = tail;
        while (head != null) {
            if (temp.remainingBurstTime > timeQuantum) {
                temp.remainingBurstTime -= timeQuantum;
                currentTime += timeQuantum;
                displayProcesses();
                prev = temp;
                temp = temp.next;
            } else {
                currentTime += temp.remainingBurstTime;
                temp.remainingBurstTime = 0;
                temp.turnAroundTime = currentTime;
                temp.waitingTime = temp.turnAroundTime - temp.burstTime;
                completedProcesses.add(temp);
                displayProcesses();
                Node nextNode = temp.next;
                removeProcess(temp.processId);
                temp = nextNode;
            }
        }
    }
    public void displayProcesses() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print("P" + temp.processId + "(" + temp.remainingBurstTime + ") ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public void displayAverages() {
        if (completedProcesses.isEmpty()) return;
        double totalWt = 0, totalTat = 0;
        for (Node p : completedProcesses) {
            totalWt += p.waitingTime;
            totalTat += p.turnAroundTime;
        }
        System.out.println("Avg WT: " + (totalWt / completedProcesses.size()));
        System.out.println("Avg TAT: " + (totalTat / completedProcesses.size()));
    }
}
