 //Name: Aneesh Peri
 //Date: 4/9/24
import java.util.*;

/* implement the API for java.util.PriorityQueue
 *     a min-heap of objects in an myHeapList<E> in a resource class
 * test this class with HeapPriorityQueue_Driver.java.
 * test this class with LunchRoom.java.
 * add(E) and remove()  must work in O(log n) time
 */
public class HeapPriorityQueue<E extends Comparable<E>> 
{
   private ArrayList<E> myHeap;
   
   public HeapPriorityQueue()
   {
      myHeap = new ArrayList<E>();
      myHeap.add(null);
   }
   
   public ArrayList<E> getHeap()   //for Codepost
   {
      return myHeap;
   }
   
   public int lastIndex()
   {
      return myHeap.size()-1;
   }
   
   public boolean isEmpty()
   {
      return myHeap.size() == 1;
   }
   
   public boolean add(E obj)
   {
      myHeap.add(obj);
      heapUp(lastIndex());
      return true;
   }
   
   public E remove()
   {  
      E remElement = null;
      if(!isEmpty())
      {
         swap(1, myHeap.size()-1);
         remElement = myHeap.remove(myHeap.size()-1);
         heapDown(1, lastIndex());
      }
      return remElement;
   }
   
   public E peek()
   {  
      if(isEmpty())
      {
         return null;
      }
      return myHeap.get(1);
   }
   
   //  it's a min-heap of objects in an ArrayList<E> in a resource class
   public void heapUp(int k)
   {
         if(k/2<1)
            return;
         if(myHeap.get(k/2).compareTo(myHeap.get(k))>0)
         {
            swap(k/2, k);
            heapUp(k/2);
         }
   }
   
   private void swap(int a, int b)
   {
      E temp = myHeap.get(a);
      myHeap.set(a, myHeap.get(b));
      myHeap.set(b, temp);
   }
   
  //  it's a min-heap of objects in an ArrayList<E> in a resource class
   public void heapDown(int k, int lastIndex)
   {
      if((2*k)>= lastIndex) 
         return;

      int minChild = (2*k);
      if((2*k)+1 < lastIndex && (myHeap.get((2*k)+1).compareTo(myHeap.get(2*k))<0))
      {
         minChild = (2*k) + 1;
      }
      
      if(myHeap.get(minChild).compareTo(myHeap.get(k))<0)
      {
         swap(k,minChild);
         heapDown(minChild, lastIndex);
      }

   }
   
   public String toString()
   {
      return myHeap.toString();
   }  
}
