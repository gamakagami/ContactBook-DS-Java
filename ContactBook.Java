import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactBook {
    private Map<String, Contact> contacts;

    public ContactBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber, String email) {
        contacts.put(name, new Contact(name, phoneNumber, email));
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Contacts:");
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    public void searchContactByName(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Contact found:");
            System.out.println(contacts.get(name));
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void searchContactByEmail(String email) {
        for (Contact contact : contacts.values()) {
            if (contact.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Contact found:");
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("**********************************");
            System.out.print("Please Enter a command: ");

            String choice = scanner.nextLine();

            switch (choice.toUpperCase()) {
                case "A":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactBook.addContact(name, phoneNumber, email);
                    break;
                case "P":
                    contactBook.viewContacts();
                    break;
                case "S":
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    contactBook.searchContactByName(searchName);
                    break;
                case "E":
                    System.out.print("Enter email to search: ");
                    String searchEmail = scanner.nextLine();
                    contactBook.searchContactByEmail(searchEmail);
                    break;
                case "D":
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    contactBook.deleteContact(deleteName);
                    break;
                case "Q":
                    System.out.println("Quitting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}
