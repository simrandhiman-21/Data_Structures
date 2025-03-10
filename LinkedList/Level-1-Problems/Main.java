class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;

    // Add ticket at the end
    public void addTicket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head; // Circular link
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket added successfully: " + ticketID);
    }

    // Remove ticket by ID
    public void removeTicket(int ticketID) {
        if (head == null) return;

        Ticket temp = head;
        Ticket prev = null;
        do {
            if (temp.ticketID == ticketID) {
                if (temp == head && temp.next == head) { 
                    head = null; 
                } else if (temp == head) {
                    prev = head;
                    while (prev.next != head) prev = prev.next;
                    head = head.next;
                    prev.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket removed successfully: " + ticketID);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found: " + ticketID);
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by Customer Name or Movie Name
    public void searchTicket(String searchValue) {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchValue) || temp.movieName.equalsIgnoreCase(searchValue)) {
                System.out.println("Found Ticket - Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No matching ticket found.");
    }

    // Calculate total booked tickets
    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Movie A", 12, "10:00 AM");
        system.addTicket(102, "Bob", "Movie B", 25, "1:00 PM");
        system.addTicket(103, "Charlie", "Movie A", 15, "10:00 AM");

        System.out.println("\nAll Tickets:");
        system.displayTickets();

        System.out.println("\nSearching for 'Movie A':");
        system.searchTicket("Movie A");

        system.removeTicket(102);

        System.out.println("\nAll Tickets after removal:");
        system.displayTickets();

        System.out.println("\nTotal booked tickets: " + system.countTickets());
    }
}
