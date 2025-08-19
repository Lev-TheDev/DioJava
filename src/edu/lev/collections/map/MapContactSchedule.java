package edu.lev.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapContactSchedule {

    private Map<String, Integer> mapContactSchedule;

    public MapContactSchedule() {
        this.mapContactSchedule = new HashMap<>();
    }

    public void addContact(String name, int phoneNumber) {
        mapContactSchedule.put(name, phoneNumber);
    }

    public void removeContact(String name) {
        if(!mapContactSchedule.isEmpty()) {
            mapContactSchedule.remove(name);
        }
    }

    public void showContacts() {
        if(!mapContactSchedule.isEmpty()) {
            for (Map.Entry<String, Integer> entry : mapContactSchedule.entrySet()) {
                System.out.println("Name: " + entry.getKey() + ", Phone Number: " + entry.getValue());
            }
        } else {
            System.out.println("No contacts available.");
        }
    }

    public Integer findByName(String name) {
        Integer numberByName = null;
        if(!mapContactSchedule.isEmpty()) {
            numberByName = mapContactSchedule.get(name);
        }
        return numberByName;
    }

    public static void main(String[] args) {
        MapContactSchedule contactSchedule = new MapContactSchedule();
        contactSchedule.addContact("Alice", 123456789);
        contactSchedule.addContact("Bob", 987654321);
        // put method can add or update contacts
        // that's why the last insertion stands, different from List or Set

        System.out.println("Contacts:");
        contactSchedule.showContacts();

        System.out.println("\nFinding Alice's number: " + contactSchedule.findByName("Alice"));

        contactSchedule.removeContact("Alice");
        System.out.println("\nContacts after removing Alice:");
        contactSchedule.showContacts();
    }
}
