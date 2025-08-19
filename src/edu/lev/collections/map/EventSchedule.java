package edu.lev.collections.map;

import java.time.LocalDate;
import java.util.*;

public class EventSchedule {

    private Map<LocalDate, Event> eventsMap;

    public EventSchedule() {
        this.eventsMap = new HashMap<>();
    }

    public void addEvent(LocalDate date, String name, String attraction) {
        eventsMap.put(date, new Event(name, attraction));
    }

    public void showEvents() {
        Map<LocalDate, Event> treeMapEvents = new TreeMap<>(eventsMap); // TreeMap to sort by date in Chronological order
        if (!eventsMap.isEmpty()) {
            treeMapEvents.forEach((date, event) ->
                System.out.println("Date: " + date + ", Event: " + event));
        } else {
            System.out.println("No events scheduled.");
        }
    }

    public void showNextEvent() {
        //Set<LocalDate> dateSet = eventsMap.keySet();
        //Collection<Event> values = eventsMap.values(); // no relation between keys and values

        if (!eventsMap.isEmpty()) {
            LocalDate today = LocalDate.now();
            Optional<Map.Entry<LocalDate, Event>> nextEvent = eventsMap.entrySet().stream()
                    .filter(entry -> entry.getKey().isAfter(today))
                    .min(Map.Entry.comparingByKey());

            nextEvent.ifPresent(entry ->
                System.out.println("Next Event --> " + entry.getValue() + " on " + entry.getKey()));
        } else {
            System.out.println("No upcoming events.");
        }



    }

    public static void main(String[] args) {
        EventSchedule schedule = new EventSchedule();
        schedule.addEvent(LocalDate.of(2025, 7, 20), "Summer Festival", "Live Music");
        schedule.addEvent(LocalDate.of(2025, 9, 15), "Art Exhibition", "Modern Art");
        schedule.addEvent(LocalDate.of(2025, 9, 10), "Tech Conference", "AI Innovations");

        System.out.println("Finding the next upcoming event: \n");
        schedule.showNextEvent();

    }
}
