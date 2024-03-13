package Stukdat;
import java.util.Scanner;

class Node {
    private String name;
    private String phoneNumber;
    private Node next;

    public Node(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class ContactManager {
    private Node head;

    public ContactManager() {
        this.head = null;
    }

    public void addContact(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        System.out.println("Kontak berhasil ditambahkan!");
    }

    public void displayContacts() {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            Node current = head;
            while (current != null) {
                System.out.println("Nama: " + current.getName() + ", Nomor Telepon: " + current.getPhoneNumber());
                current = current.getNext();
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        Node current = head;
        while (current != null) {
            if (current.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan:");
                System.out.println("Nama: " + current.getName() + ", Nomor Telepon: " + current.getPhoneNumber());
                found = true;
                break;
            }
            current = current.getNext();
        }
        if (!found) {
            System.out.println("Kontak tidak ditemukan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        System.out.println("Selamat datang di Manajemen Kontak!");

        int choice;
        do {
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilan Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1/2/3/4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama kontak: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon: ");
                    String phoneNumber = scanner.nextLine();
                    Node newNode = new Node(name, phoneNumber);
                    contactManager.addContact(newNode);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan nama yang akan dicari: ");
                    String searchName = scanner.nextLine();
                    contactManager.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
