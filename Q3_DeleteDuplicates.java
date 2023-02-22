package HvLLAssignment;
class LinkedList2 {
    Node2 head;
    Node2 tail;
    int size;
    LinkedList2(){
        this.size=0;
    }
    public  void insertAtStart(int val){
        Node2 node = new Node2(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }
    public void insertAtLast(int val){
        if(tail==null){
            insertAtStart(val);
            return;
        }
        Node2 temp = new Node2(val);
        tail.next = temp;
        tail = temp;
        size++;

    }
    public void display(){
        Node2 temp = head;
        while(temp!=null){
            System.out.print(temp.val+"--> ");
            temp = temp.next;
        }
        System.out.print("End");
    }
    public void deleteDuplictes(){
        Node2 node = head;
        while(node.next!=null){
            if(node.val==node.next.val){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
    }
    public void sort(){
        Node2 temp1 = head;
        while(temp1.next!=null){
            Node2 temp2 = temp1.next;
            while (temp2.next!=null){
                if(temp2.val<temp1.val){
                    int nodeData = temp1.val;
                    temp1.val = temp2.val;
                    temp2.val = nodeData;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }
}
class Node2 {
    int val;
    Node2 next;

    public Node2(int val) {
        this.val = val;
    }

    public Node2(int val, Node2 next) {
        this.val = val;
        this.next = next;
    }
}
public class Q3_DeleteDuplicates {
    public static void main(String[] args) {
        LinkedList2 li = new LinkedList2();
        li.insertAtLast(2);
        li.insertAtLast(5);
        li.insertAtLast(12);
        li.insertAtLast(2);
        li.insertAtLast(3);
        li.insertAtLast(5);
        li.insertAtLast(1);
        li.insertAtLast(2);
        li.insertAtLast(5);
        li.insertAtLast(5);
        System.out.println("linked list is");
        li.display();
        System.out.println();
        li.sort();
        li.deleteDuplictes();
        System.out.println("After deleteing duplicates linked list is");
        li.display();


    }
}
