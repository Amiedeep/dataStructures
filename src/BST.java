
import java.util.Scanner;


public class BST 
{
    BSTNode root;
    
    
    void insert(int value)
    {
        BSTNode parent=null;//if you want to delete root then parent would be null.
        BSTNode ptr=root;
        
        while(ptr!=null)
        {
            parent=ptr;
            if(value>ptr.data)
                ptr=ptr.right;
            else
                ptr=ptr.left;
        }
        if(parent==null)
            root=new BSTNode(value);
        else if(value>parent.data)
            parent.right=new BSTNode(value);
        else
            parent.left=new BSTNode(value);
    }
//    void insert(int data_node)
//    {
//            root=insert(root,data_node);
//    }
//    
//    
//    BSTNode insert(BSTNode node,int data_node)
//    {
//        
//        if(node==null)
//        {
//            node=new BSTNode();
//            node.data=data_node;
//        }
//        
//        else
//        {
//            if(node.data>data_node)
//                node.left=insert(node.left,data_node);
//            
//            else
//                node.right=insert(node.right,data_node);
//        }     
//        return node;
//    }
    
    
    
    void inOrder(BSTNode node)
    {
        if(node!=null)
        {
            inOrder(node.left);
            System.out.print(node.data+"\t");
            inOrder(node.right);
        }
    }
    
    
    
    void postOrder(BSTNode node)
    {
        if(node!=null)
        {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+"\t");
        }
    }
    
    
    
    void preOrder(BSTNode node)
    {
        if(node!=null)
        {
            System.out.print(node.data+"\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    
    
    void traverse()
    {
        System.out.println("preorder traversal is: ");
        preOrder(root);
        System.out.println("\ninorder traversal is: ");
        inOrder(root);
        System.out.println("\npostorder traversal is: ");
        postOrder(root);
    }
    
    
    
    void delete(int k)//to delete a node with data k
    {
        
        if(search(k)==false)//if node is not present then return
            return;
        
        
        BSTNode parent=null;//if you want to delete root then parent would be null.
        BSTNode ptr=root;
        
        while(ptr.data!=k)
        {
            parent=ptr;
            if(k>ptr.data)
                ptr=ptr.right;
            else
                ptr=ptr.left;
        }
        
        if(ptr.left==null && ptr.right==null)//if both child's of found node are null.
        {
            if(parent==null)//if the node is root.
                root=null;
            else if(parent.left==ptr)
                parent.left=null;
            else
                parent.right=null;
        }
        
        else if(ptr.left==null)//if left child of node is null
        {
            BSTNode temp=ptr.right;
            ptr.data=temp.data;
            ptr.left=temp.left;
            ptr.right=temp.right;
        }
        
        else if(ptr.right==null)//if right child of node is null
        {
            BSTNode temp=ptr.left;
            ptr.data=temp.data;
            ptr.left=temp.left;
            ptr.right=temp.right;
        }
        
        else//if both the child's are not null.complex case need to find inorder successor.
        {
           int temp=inOrderSuccessor(ptr);
           delete(temp);
           ptr.data=temp;
        }
        
    }
    
    
    
    int inOrderSuccessor(BSTNode ptr)//it finds inorder successor of ptr.
    {
        if(ptr.right==null)
            return ptr.data;
        
        ptr=ptr.right;
        
        while(ptr.left!=null)
            ptr=ptr.left;
        
        return ptr.data;
            
    }
    
    
    
    boolean search(int k)
    {
        BSTNode ptr=root;
        while(ptr!=null)
        {
            if(ptr.data==k)
                break;
            else if(ptr.data>k)
                ptr=ptr.left;
            else
                ptr=ptr.right;
        }
        if(ptr==null)
        {
            System.out.println("item not found");
            return false;
        }
            
        else
        {
            System.out.println("item found");
            return true;
        }
    }
    
    
    
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1 to insert,2 to delete,3 to search,4 to traverse,5 to exit");
        int n=sc.nextInt();
        BST obj=new BST();
        while(n!=5)
        {
            switch(n)
            {
                case 1 :
                    System.out.println("enter data");
                    obj.insert(sc.nextInt());
                    break;
                case 2 :
                    System.out.println("enter item to be deleted");
                    obj.delete(sc.nextInt());
                    break;
                case 3 :
                    System.out.println("item to be searched??");
                    obj.search(sc.nextInt());
                    break;
                case 4 :
                    obj.traverse();
                    System.out.println();
                    break;
            }
            System.out.println("enter 1 to insert,2 to delete,3 to search,4 to traverse,5 to exit");
            n=sc.nextInt();
        }
        
    }
}


class BSTNode
{
    BSTNode left;
    BSTNode right;
    int data;
    BSTNode(int value)
    {
        data=value;
    }
}
