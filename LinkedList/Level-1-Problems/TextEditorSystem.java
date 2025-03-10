class TextNode {
    String text;
    TextNode next;
    TextNode prev;

    TextNode(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextNode head;
    private TextNode current;
    private int maxSize;
    private int size;

    TextEditor(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
    }

    // Add new text state
    public void addState(String text) {
        TextNode newNode = new TextNode(text);
        if (head == null) {
            head = current = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        size++;
        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
        System.out.println("Current state: " + current.text);
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.text);
        } else {
            System.out.println("Undo: No previous state.");
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.text);
        } else {
            System.out.println("Redo: No further state.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current state: " + current.text);
        } else {
            System.out.println("No current state available.");
        }
    }
}

public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.undo();
        editor.undo();
        editor.redo();

        editor.displayCurrentState();

        editor.addState("New Content");
        editor.displayCurrentState();
    }
}
