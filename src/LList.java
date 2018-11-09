
import java.util.LinkedList;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LList
{
    LListNode root;
    void insert(int value)//to insert new node with value at the last of linked list
    {
        if(root==null)
            root=new LListNode(value);
        else
        {
            LListNode ptr=root;
            while(ptr.next!=null)
                ptr=ptr.next;
            ptr.next=new LListNode(value);
        }
    }
    
    
    void delete(int value)//to delete node with value in linked list
    {
        LListNode ptr=root;
        if(root==null)
            System.out.println("empty list");
        else if(root.data==value)
            root=root.next;
        else
        {
            while(ptr.next!=null)
            {
                if(ptr.next.data==value)
                {
                    ptr.next=ptr.next.next;
                    return;
                }
                else
                    ptr=ptr.next;
            }
            System.out.println("There is no element with this value");
        }
    }
    boolean search(int value)//to search for a node with given value in linked list.
    {
        LListNode ptr=root;
        while(ptr!=null)
        {
            if(ptr.data==value)
            {
                System.out.println("Element found");
                return true;
            }    
            ptr=ptr.next;
        }
        System.out.println("There is no element with this value");
        return false;
    }
    void traverse()//to traverse it satrting from head
    {
        LListNode ptr=root;
        while(ptr!=null)
        {
            System.out.print(ptr.data+"-->");
            ptr=ptr.next;
        }
        System.out.print("null");
        System.out.println();
    }
    void reverse()
    {
        if(root==null || root.next==null)
            return;
        LListNode ptr=root;
        reverse(ptr);
        ptr.next=null;
        System.out.println("linked list after reverse is :");
        traverse();
    }
    private void reverse(LListNode node)
    {
        if(node.next.next!=null)
            reverse(node.next);
        else
            root=node.next;
        
        node.next.next=node;
    }

    private LListNode reverseSecondHalf(LListNode node)
    {
        if(node.next == null)
            return node;

        LListNode lastNode = reverseSecondHalf(node.next);
        node.next.next = node;
        return  lastNode;
    }


    public static void main(String[] args) 
    {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("enter 1 to insert,2 to delete,3 o traverse,4 to reverse,5 to  search,6 to exit");
        LList linkedList = new LList();
        linkedList.insert(40);
        linkedList.insert(20);
        linkedList.insert(60);
//        linkedList.insert(10);
        linkedList.insert(50);
        linkedList.insert(30);
        LListNode middleNode = linkedList.findMiddle(linkedList.root);
        LListNode startNextHalfNode = linkedList.reverseSecondHalf(middleNode.next);
        middleNode.next.next = null;
        middleNode.next = startNextHalfNode;

//        linkedList.root = linkedList.mergeSort(linkedList.root);
        linkedList.printList();

//        int n=sc.nextInt();
//        while(n!=6)
//        {
//            switch(n)
//            {
//                case 1:
//                    System.out.println("enter value to insert");
//                    obj.insert(sc.nextInt());
//                    break;
//                case 2:
//                    System.out.println("enter value to delete");
//                    obj.delete(sc.nextInt());
//                    break;
//                case 3:
//                    obj.traverse();
//                    break;
//                case 4:
//                    obj.reverse();
//                    break;
//                case 5:
//                    System.out.println("enter value to search");
//                    obj.search(sc.nextInt());
//                    break;
//
//                default:
//                    System.out.println("please enter valid input");
//                    break;
//            }
//            System.out.println("enter 1 to insert,2 to delete,3 o traverse,4 to reverse,5 to search,6 to exit");
//            n=sc.nextInt();
//        }
    }

    private void printList() {
        LListNode node = root;
        while (nonNull(node)) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private LListNode mergeSort(LListNode node) {
        if(length(node) < 2)
            return node;
        LListNode middleNode = findMiddle(node);
        LListNode secondHalf = middleNode.next;
        middleNode.next = null;
        LListNode leftList = mergeSort(node);
        LListNode rightList = mergeSort(secondHalf);

        return sortLists(leftList, rightList);
    }

    private LListNode sortLists(LListNode firstNode, LListNode secondNode) {
        if (isNull(firstNode))
            return secondNode;
        else if(isNull(secondNode))
            return firstNode;
        if(firstNode.data > secondNode.data) {
            secondNode.next = sortLists(firstNode, secondNode.next);
            return secondNode;
        }
        else {
            firstNode.next = sortLists(firstNode.next, secondNode);
            return firstNode;
        }

    }

    private int length(LListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private LListNode findMiddle(LListNode node) {
        LListNode slowPointer = node;
        LListNode fastPointer = node;
        while(fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
