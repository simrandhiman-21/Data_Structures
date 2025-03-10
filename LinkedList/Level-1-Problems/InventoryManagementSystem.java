class Item {
    String name;
    int itemId;
    int quantity;
    double price;
    Item next;

    Item(String name, int itemId, int quantity, double price) {
        this.name = name;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    // Add item at the beginning
    public void addAtBeginning(String name, int itemId, int quantity, double price) {
        Item newItem = new Item(name, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at the beginning: " + name);
    }

    // Add item at the end
    public void addAtEnd(String name, int itemId, int quantity, double price) {
        Item newItem = new Item(name, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
        System.out.println("Item added at the end: " + name);
    }

    // Remove item by ID
    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed with ID: " + itemId);
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Item removed with ID: " + itemId);
        } else {
            System.out.println("Item not found with ID: " + itemId);
        }
    }

    // Update quantity by ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Updated quantity for Item ID " + itemId + " to " + newQuantity);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found with ID: " + itemId);
    }

    // Search item by ID or name
    public void searchItem(int itemId, String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId || temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found Item: " + temp.name + " - Quantity: " + temp.quantity + " - Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    // Display inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " - ID: " + temp.itemId + " - Quantity: " + temp.quantity + " - Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addAtEnd("Item1", 101, 10, 25.50);
        inventory.addAtBeginning("Item2", 102, 5, 30.75);
        inventory.addAtEnd("Item3", 103, 20, 15.25);

        System.out.println("\nCurrent Inventory:");
        inventory.displayInventory();

        System.out.println("\nSearching for Item with ID 102:");
        inventory.searchItem(102, "");

        inventory.updateQuantity(101, 15);

        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());

        inventory.removeById(102);

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}