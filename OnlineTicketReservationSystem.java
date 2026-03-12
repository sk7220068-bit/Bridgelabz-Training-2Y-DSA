class OnlineTicketReservationSystem {
    class Node {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;
        public Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int totalTickets = 0;
    public void addReservation(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        totalTickets++;
    }
    public void removeTicket(int ticketId) {
        if (head == null) return;
        if (head == tail && head.ticketId == ticketId) {
            head = tail = null;
            totalTickets--;
            return;
        }
        Node temp = head, prev = tail;
        do {
            if (temp.ticketId == ticketId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                totalTickets--;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    public void displayTickets() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchTicket(String name) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.customerName.equals(name) || temp.movieName.equals(name)) {
                System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName);
            }
            temp = temp.next;
        } while (temp != head);
    }
    public int getTotalTickets() {
        return totalTickets;
    }
}
