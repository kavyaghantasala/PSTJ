package pst;

import java.time.LocalDate;
import java.util.*;

class Event {
    String name;
    LocalDate date;

    Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of events: ");
        int n = sc.nextInt();
        List<Event> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter event name: ");
            String name = sc.next(); // use sc.nextLine() if names have spaces
            System.out.print("Enter event date (YYYY-MM-DD): ");
            String dateStr = sc.next();
            LocalDate date = LocalDate.parse(dateStr);
            events.add(new Event(name, date));
        }

        System.out.print("Enter month number to filter events: ");
        int month = sc.nextInt();

        // Sort events by date
        events.sort(Comparator.comparing(e -> e.date));

        // Print all events by name
        System.out.println("All events in chronological order:");
        for (Event e : events) {
            System.out.print(e.name + " ");
        }
        System.out.println();

        // Print earliest event
        System.out.println("Earliest event: " + events.get(0).name);

        // Print latest event
        System.out.println("Latest event: " + events.get(events.size() - 1).name);

        // Print events of specific month
        System.out.println("Events in month " + month + ":");
        for (Event e : events) {
            if (e.date.getMonthValue() == month) {
                System.out.print(e.name + " ");
            }
        }

        sc.close();
    }
}
