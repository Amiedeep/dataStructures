
import java.util.Scanner;
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
    void reverse(LListNode node)
    {
        if(node.next.next!=null)
            reverse(node.next);
        else
            root=node.next;
        
        node.next.next=node;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1 to insert,2 to delete,3 o traverse,4 to reverse,5 to exit");
        int n=sc.nextInt();
        LList obj=new LList();
        while(n!=6)
        {
            switch(n)
            {
                case 1:
                    System.out.println("enter value to insert");
                    obj.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.println("enter value to delete");
                    obj.delete(sc.nextInt());
                    break;
                case 3:
                    obj.traverse();
                    break;
                case 4:
                    obj.reverse();
                    break;
                case 5:
                    System.out.println("enter value to search");
                    obj.search(sc.nextInt());
                    break;
               
                default:
                    System.out.println("please enter valid input");
                    break;
            }
            System.out.println("enter 1 to insert,2 to delete,3 o traverse,4 to reverse,5 to search,6 to exit");
            n=sc.nextInt();
        }
    }
}
