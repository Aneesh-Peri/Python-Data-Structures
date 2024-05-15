// Name:
// Date:

//  DoubleLinkedList, circular, with a dummy head node
//  implements some of the List and LinkedList interfaces:
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o);
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

class DLL
{
   private int size;
   private DLNode head; //points to a dummy node--very useful--don't mess with it
   public DLL()
   {
      //make it circular
      head = new DLNode(null,null,null);
      head.setPrev(head);
      head.setNext(head);
      size = 0;
   }

   /* two accessor methods  */
   public int size()
   {
      return size;
   }
   public DLNode getHead()
   {
      return head;
   }

   /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;
   }

   /* inserts obj at position index (the list is zero-indexed).
      increments size.
      no need for a special case when size == 0.
	   */
   // Example for this is head -> 1 -> 2 -> 3 -> 4. Assume that everything has a prev and next
   // Assume subNode in this case is 1.5
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:  " + size);
        }
        else
        {
            DLNode looper = head.getNext();
            DLNode subNode = new DLNode(obj,looper.getPrev(),looper);
            for(int i = 0; i<=index;i++)
            {
                looper = looper.getNext();
            }
            subNode.setNext(looper.getNext());
           // In the above example, the next node for 1.5 will be set to 4
            looper.getNext().setPrev(subNode);
           // In the above example, the previous node for 4 will be pointing to 1.5
            subNode.setPrev(looper);
           // In the above example, the prev for Subnode will point to the next of 3
            looper.setNext(subNode);
           // In the above example, we are setting the pointer for next node for 3 to the prev pointer for 1.5
        }
   }

   /* return obj at position index (zero-indexed).
    */
   public Object get(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode looper = head;

      for(int i = 0; i <= index; i++)
      {
         looper = looper.getNext();
      }
      return looper.getValue();

   }

   /* replaces obj at position index (zero-indexed).
        returns the obj that was replaced.
        */
   public Object set(int index, Object obj) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
         /* enter your code below  */
      else {
         DLNode looper = head;
         for(int i = 0; i <= index;i++)
         {
            looper=looper.getNext();
         }
         Object current = looper.getValue();
         looper.setValue(obj);
         return current;
      }
   }

   /*  removes the node from position index (zero-indexed).  decrements size.
       @return the object in the node that was removed.
        */
   public Object remove(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode temporary = head;
      for(int i = 0; i <= index;i++)
         temporary=temporary.getNext();

      Object tempvalue = temporary.getValue();
      temporary.getPrev().setNext(temporary.getNext());
      temporary.getNext().setPrev(temporary.getPrev());
      size--;
      return tempvalue;
   }

   /* inserts obj to front of list, increases size.
    */
   public void addFirst(Object obj)
   {
      DLNode temp = new DLNode(obj, head, head.getNext());
      head.setNext(temp);
      temp.getNext().setPrev(temp);
      size++;
   }

   /* appends obj to end of list, increases size.
    */
   public void addLast(Object obj)
   {

      DLNode temp = new DLNode(obj,head,head.getNext());
      if (head == null)
      {
         head = temp;
         head.setNext(temp);
         head.setPrev(temp);
      }
      else
      {
         DLNode last = head.getPrev();

         last.setNext(temp);
         temp.setPrev(last);
         temp.setNext(head);
         head.setPrev(temp);
      }
      size++;
   }

   /* returns the first element in this list
    */
   public Object getFirst()
   {
      return head.getNext().getValue();
   }

   /* returns the last element in this list
    */
   public Object getLast()
   {
      return head.getPrev().getValue();
   }

   /* returns and removes the first element in this list, or
      returns null if the list is empty
      */
   public Object removeFirst()
   {
      if(head==null)
      {
         return null;
      }
      DLNode next = head.getNext();
      DLNode remover = head.getNext();
      next.getPrev().setNext(next.getNext());
      next.getNext().setPrev(next.getPrev());
      size--;
      return remover.getValue();

   }

   /* returns and removes the last element in this list, or
      returns null if the list is empty
      */
   public Object removeLast()
   {
      if (head == null || size == 0)
      {
         return null;
      }
      else
      {
         DLNode lastNode = head.getPrev();
         lastNode.getPrev().setNext(head);
         head.setPrev(lastNode.getPrev());
         size--;

         return lastNode.getValue();
      }
   }

   /*  returns a String with the values in the list in a
       friendly format, for example   [Apple, Banana, Cucumber]
       The values are enclosed in [], separated by one comma and one space.
       An empty list returns [].
    */
   public String toString()
   {
      String result = "[";
      DLNode current = head.getNext();

      while (current != head) {
         result += current.getValue();
         if (current.getNext() != head) {
            result += ", ";
         }
         current = current.getNext();
      }

      result += "]";
      return result;
   }
}