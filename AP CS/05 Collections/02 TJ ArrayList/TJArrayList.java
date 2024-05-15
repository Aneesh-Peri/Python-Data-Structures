// Name: 
// Date:

import java.util.ArrayList;

/**
 * Implements the cheat sheet's List interface.  Implements generics.
 * The backing array is an array of (E[]) new Object[10];
 * @override toString()
 */ 
public class TJArrayList<E>
{
   private int size;							//stores the number of objects
   private E[] myArray;
   @SuppressWarnings("unchecked")
   public TJArrayList()                
   {
      myArray = (E[]) new Object[10]; //default constructor instantiates a raw array with 10 cells
      size = 0;
   }
   public int size()
   {
      return size;
   }
 	/* appends obj to end of list; increases size;
      must be an O(1) operation when size < array.length, 
         and O(n) when it doubles the length of the array.
	  @return true  */
   @SuppressWarnings("unchecked")
   public boolean add(E obj)
   {
       if(size<myArray.length)
       {
           myArray[size] = obj;
       }
       else
       {
           E[] tempArray = (E[]) new Object[size*2];
           for(int i = 0; i<myArray.length;i++)
               tempArray[i] = myArray[i];
           myArray = tempArray;
           myArray[size] = obj;
       }
       size++;
       return true;
   }
   /* inserts obj at position index.  increments size. 
		*/
    @SuppressWarnings("unchecked")
   public void add(int index, E obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

      if(size+1> myArray.length)
      {
          E[] newArray = (E[]) new Object[myArray.length*2];
          for(int i  = 0; i < myArray.length;i++)
              newArray[i] = myArray[i];
          myArray = newArray;

      }

      for(int i = size;i>index;i--)
          myArray[i] = myArray[i-1];
      size++;
      myArray[index] = obj;



   }


   /* return obj at position index.  
		*/
   public E get(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
     
      return myArray[index];
   }
   /**
    * Replaces obj at position index. 
    * @return the object is being replaced.
    */  
   public E set(int index, E obj) throws IndexOutOfBoundsException  
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

      E value = myArray[index];
      myArray[index] = obj;
      return value;

   }
 /*  removes the node from position index. shifts elements 
     to the left.   Decrements size.
	  @return the object that used to be at position index.
	 */
   public E remove(int index) throws IndexOutOfBoundsException  
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

      E value = (E) myArray[index];
      for(int i = index;i < myArray.length-1;i++)
      {
          myArray[i] = myArray[i+1];
      }
      myArray[myArray.length-1]  = null;
      size--;
      return value;

   }
	   /*
		   This method compares objects.
         Must use .equals(), not ==
     	*/
   public boolean contains(E obj)
   {
       for (E  e : myArray) {
           if (obj.equals(e)) {
               return true;
           }
       }
        return false;

   }
	 /*returns a String of E objects in the array with 
       square brackets and commas.
     	*/
   public String toString()
   {
        String starter = "[";
        for(int i = 0; i < size;i++)
        {
            if(i==size-1)
            {
                starter += myArray[i];
            }
            else
            {
                starter += myArray[i]+", ";
            }

        }
        starter +=  "]";
        return starter;
   }
}