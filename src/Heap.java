import java.util.ArrayList;
import java.util.Scanner;
public class Heap 
{
    ArrayList<Integer> al; 
    Heap()
    {
        al=new ArrayList<>();
    }
    Heap(int[] array)//in case you want to initialize heap with array
    {
        al=new ArrayList<>();
        for (int i = 0; i < array.length; i++) 
        {
            insert(array[i]);
        }
    }
    int[] heapSort() //or we can make it static to use in other classes
    {
        int[] a=new int[al.size()];
        for (int i = 0; i < a.length; i++) 
        {
            a[i]=delete();
        }
//        System.out.println("array lenght : "+a.length);
        return a;
    }
    void insert(int data)
    {
        al.add(data);
        insert();
    }
    int delete()//to delete root of heap
    {
        int item=al.get(0);
        reHeapify();
//        System.out.println("deleted");
        return item;
    }
    void reHeapify()//to make it heap again after deletion
    {
        al.set(0, al.get(al.size()-1));
        int item=al.get(0);
        al.remove(al.size()-1);
        int i=0;
        int leftIndex;
        int rightIndex;
        while(i<(al.size())/2)//or while have leftIndex.change the code for understandability
        {
            leftIndex=(2*i)+1;
            rightIndex=(2*i)+2;
            if(leftIndex==al.size()-1)//if node have only left child
            {
                if(al.get(leftIndex)>item)
                {
                    al.set(i, al.get(leftIndex));
                    al.set(leftIndex, item);
                }
                i=leftIndex;
            }
            else if(al.get(leftIndex)>=al.get(rightIndex) && item<al.get(leftIndex))//= handle duplicacy
            {
                al.set(i, al.get(leftIndex));
                al.set(leftIndex, item);
                i=leftIndex;
            }
            else if(al.get(leftIndex)<al.get(rightIndex) && item<al.get(rightIndex))
            {
                al.set(i, al.get(rightIndex));
                al.set(rightIndex, item);
                i=rightIndex;
            }
            else//if node value is greater than both of its childs
                break;
        }
//        traverse();
    }
    void insert()//compare with parent n proceed
    {
        int i=al.size()-1;
        int item;
//        System.out.println("ADDED");
        while(i>0)
        {
            if(al.get(i)>al.get((i-1)/2))
            {
                item=al.get(i);
                al.set(i, al.get((i-1)/2));
                al.set((i-1)/2, item);
                i=(i-1)/2;
                continue;
            }
            break;
        }
    }
    void traverse()
    {
        for (int i = 0; i < al.size(); i++) 
        {
            System.out.print(al.get(i)+"  ");
        }
    }
    public static void main(String[] args) 
    {
//        Heap obj=new Heap();
        System.out.println("how many elements to add?");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("enter elements");
//        for (int i = 0; i <n; i++) 
//        {
//            obj.insert(sc.nextInt());
//        }
//        obj.traverse();
//        for (int i = 0; i <n; i++) 
//        {
//            System.out.print(obj.delete()+"  ");
//        }
        int[] elements=new int[n];
        for (int i = 0; i < n; i++) 
        {
            elements[i]=sc.nextInt();
        }
        Heap obj=new Heap(elements);
//        obj.traverse();
        System.out.println();
        int[] output=obj.heapSort();//return sorted array
//        System.out.println("output lenght : "+output.length);
        System.out.println("elements after sorting are :");
        for (int i = 0; i < n; i++) 
        {
            System.out.println(output[i]);
        }
    }
}
