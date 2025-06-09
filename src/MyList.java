package src;

import java.util.LinkedList;

public class MyList {
    LinkedList<Integer> list = new LinkedList<>();

    public void add(int data){
        list.add(data);
    }

    public void printList(){
        System.out.println(list);
    }

    public void delete(int data){
        list.remove(data);
    }

    public static void main(String args[]){
        MyList list = new MyList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        list.printList();

        list.delete(2);
        list.printList();
    }
}
