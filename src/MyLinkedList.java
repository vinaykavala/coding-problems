package src;

// Node class represents individual elements in the linked list
class Node{
    Node next;
    int data;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    Node head; // reference to the first node in the list

    public MyLinkedList(){
        this.head = null; // initially the list is empty
    }

    // method to add a new node to the end of the list
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode; // if the list is empty, the new node becomes the head
        }else{
            Node current =  head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;// link the last node to the new node
        }
    }

    public void insertAt(int data, int index){
        Node node = new Node(data);

        if(index == 0){
            node.next = head;
            head = node;
            return;
        }else{
            Node current = head;
            for(int i=0; i<index-1 && current.next!=null; i++){
                current = current.next; // go until the last node
            }

            if(current == null)
            System.out.println("Out of Bounds!!");

            node.next = current.next;
            current.next = node;
        }
    }

    public void delete(int position){
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
    
        if(position == 0){
            head = head.next;
            return;
        } else { // It's good practice to use an 'else' block here for clarity
            Node current = head;
            for(int i=0; i<position-1; i++){
                if(current.next == null){
                    // Added this line for consistent feedback
                    System.out.println("Position out of bounds during traversal. Cannot delete.");
                    return;
                }
                current = current.next;
            }
    
            if(current.next == null){
                System.out.println("Position out of bounds. Cannot delete (likely tried to delete beyond the list end).");
                return;
            }
    
            current.next = current.next.next;
        }
    }

    public void delete(Node data){
        if (head == null) {
            System.out.println("You can't delete from an empty list.");
            return;
        }
    
        // Case 1: The head node is the one to be deleted
        if (head == data) { // Compares object references
            head = head.next;
            return;
        }
    
        // Case 2: Traverse to find the node *before* the one to be deleted
        Node current = head;
        while (current.next != null && current.next != data) {
            current = current.next;
        }
    
        // After the loop, current.next is either null (node not found) or nodeToDelete
        if (current.next == null) {
            System.out.println("Node not found in the list.");
            return; // Node was not found, nothing to delete
        }
    
        // Case 3: Node found, perform deletion
        current.next = current.next.next;
    }

    public void printList(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]){
        MyLinkedList list = new MyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.printList();
    }
    
}
