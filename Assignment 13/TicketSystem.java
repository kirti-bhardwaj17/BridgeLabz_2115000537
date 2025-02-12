public class TicketSystem {
	class Node {
		Node next, prev;
		int Ticket_id;
		String Customer_name;
		String Movie_name;
		int Seat_number;
		String Booking_time;

		Node(int Ticket_id, String Customer_name, String Movie_name, int Seat_number, String Booking_time) {
			this.Ticket_id = Ticket_id;
			this.Customer_name = Customer_name;
			this.Movie_name = Movie_name;
			this.Seat_number = Seat_number;
			this.Booking_time = Booking_time;
			this.next = null;
			this.prev = null;
		}
	}

	Node head, tail;

	public void addLast(int Ticket_id, String Customer_name, String Movie_name, int Seat_number, String Booking_time) {
		Node newNode = new Node(Ticket_id, Customer_name, Movie_name, Seat_number, Booking_time);
		if (head == null) {
			head = tail= newNode;
			head.next = head;
			head.prev = head;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		newNode.next = head;
		head.prev = newNode;
		tail = newNode;
	}

	public void remove(int Ticket_id) {
		Node current = head;
		Node previous = null;
		while (current != null && current.Ticket_id != Ticket_id) {
			previous = current;
			current = current.next;
		if (current == head) {
			System.out.println("id not found");
			return;
		}
	 } 
	 if(current == head && current == tail) {
			head = tail = null;

		} else if (current == head) {
			head = head.next;
			head.prev = tail;
			tail.next = head;
		}
		else if (current == tail) {
			tail = tail.prev;
			tail.next = head;
			head.prev = tail;
		}
		else {
			previous.next = current.next;
			current.next.prev = previous;
		}
	}

	public void display() {
		if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
		Node current = head;
		while (true) {
			System.out.println("ID: " + current.Ticket_id + ", Customer: " + current.Customer_name +
                    ", Movie: " + current.Movie_name + ", Seat: " + current.Seat_number +
                    ", Time: " + current.Booking_time);
			current = current.next;
			if (current == head)
				break;
		}
	}

	public void search(String Customer_name) {
		 if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
		Node current = head;
		while (current.Customer_name != Customer_name) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("ticket not found");
		} else {
			System.out.println("ID: " + current.Ticket_id + ", Customer: " + current.Customer_name +
                    ", Movie: " + current.Movie_name + ", Seat: " + current.Seat_number +
                    ", Time: " + current.Booking_time);

		}
	}

	public static void main(String args[]) {
		TicketSystem t = new TicketSystem();
		t.addLast(01, "Kirti", "deadpool", 56, "5-45pm");
		t.addLast(02, "Ki", "chhava", 59, "5-15pm");
		t.addLast(03, "alice", "maharaja", 78, "5-45pm");
		t.display();
		t.remove(01);
		t.display();
		t.search("alice");
		t.display();
	}
}
