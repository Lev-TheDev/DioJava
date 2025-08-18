package edu.lev.collections.set;

import java.util.HashSet;
import java.util.Set;

public class ContactSchedule {

    private Set<Contact> contacts;

    public ContactSchedule() {
        this.contacts = new HashSet<>();
    }

    public void addContact(String name, int phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
    }

    public void showContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public Set<Contact> findContactByFirstName(String name) {
        Set<Contact> foundContacts = new HashSet<>();
        for (Contact contact : contacts) {
            if (contact.getName().startsWith(name)) {
                foundContacts.add(contact);
            }
        }
        return foundContacts;
    }

    public Contact updateContactPhone(String name, int newPhoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setPhoneNumber(newPhoneNumber);
                return contact;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ContactSchedule schedule = new ContactSchedule();
        System.out.println("Contacts in the schedule:");
        schedule.showContacts();

        schedule.addContact("Alice", 123456789);
        schedule.addContact("Alice", 223456788);
        schedule.addContact("Alice Smith", 223456008);
        schedule.addContact("Bob", 987654321);
        schedule.addContact("Bob Brown", 9999888);
        schedule.addContact("Charlie", 555555555);

        System.out.println("Contacts in the schedule:");
        schedule.showContacts();

        System.out.println("\nFinding contact by first name 'Alice':");
        Set<Contact> foundContacts = schedule.findContactByFirstName("Alice");
        for (Contact contact : foundContacts) {
            System.out.println(contact);
        }

        System.out.println("\nUpdating Alice's phone number:");
        Contact updatedContact = schedule.updateContactPhone("Alice", 111111111);
        if (updatedContact != null) {
            System.out.println("Updated contact: " + updatedContact);
        } else {
            System.out.println("Contact not found.");
        }

        System.out.println("\nContacts after update:");
        schedule.showContacts();
    }
}
