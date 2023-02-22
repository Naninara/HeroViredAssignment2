package HvLLAssignment;
class LinkedList{
    Node head;
    Node tail;
    int size;
    LinkedList(){
        this.size=0;
    }
    public  void insertAtStart(int val){
        Node node = new Node(val);
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
        Node temp = new Node(val);
        tail.next = temp;
        tail = temp;
        size++;

    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+"--> ");
            temp = temp.next;
        }
        System.out.print("End");
    }
    public LinkedList merge(LinkedList l1 , LinkedList l2){
        Node head1 = l1.head;
        Node head2 = l2.head;
        LinkedList ans = new LinkedList();
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                ans.insertAtLast(head1.val);
                head1 = head1.next;
            }
            else{
                ans.insertAtLast(head2.val);
                head2 = head2.next;
            }
        }
        while (head1!=null){
            ans.insertAtLast(head1.val);
            head1 = head1.next;
        }
        while (head2!=null){
            ans.insertAtLast(head2.val);
            head2 = head2.next;
        }
        return ans;
    }
    public void sort(){
        Node temp1 = head;
        while(temp1.next!=null){
            Node temp2 = temp1.next;
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
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class Q2_MergeAndSortTwoLinkedLists {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertAtLast(2);
        l1.insertAtLast(5);
        l1.insertAtLast(12);
        l1.insertAtLast(2);
        l1.insertAtLast(3);
        l1.insertAtLast(5);
        l1.insertAtLast(1);
        l1.insertAtLast(2);
        l1.insertAtLast(5);
        l1.insertAtLast(5);
        System.out.println("1st linked is");
        l1.display();
        System.out.println();
        LinkedList l2 = new LinkedList();
        l2.insertAtLast(2);
        l2.insertAtLast(5);
        l2.insertAtLast(12);
        l2.insertAtLast(3);
        l2.insertAtLast(1);
        System.out.println("2st linked is");
        l2.display();
        System.out.println();
        LinkedList ans = l1.merge(l1,l2);
        ans.sort();
        System.out.println("after merging and sorting");
        ans.display();
    }
}
