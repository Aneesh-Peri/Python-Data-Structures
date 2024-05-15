public class DLNODECOPY {
    private int size;
    private DLNode head; // this is a dummy node

    public DLNODECOPY()
    {
        head = new DLNode(null,null,null);
        head.setPrev(head);
        head.setNext(head);
    }
    public boolean add(Object obj)
    {
        addLast(obj);
        return true;
    }
    // Example for this is head -> 1 -> 2 -> 3 -> 4. Assume that everything has a prev and next
    // Assume subNode in this case is 1.5
    public void add(int index,Object obj) throws IndexOutOfBoundsException
    {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:  " + size);
        }
        else
        {
            DLNode looper = head.getNext();
            DLNode subNode = new DLNode(obj,looper.getPrev(),looper);
            for(int i = 0; i<index;i++)
            {
                looper = looper.getNext();
            }
            subNode.setNext(looper.getNext()); // Use the example commented above if confused
            // In the above example, the next node for 1.5 will be set to 4
            looper.getNext().setPrev(subNode);
            // In the above example, the previous node for 4 will be pointing to 1.5
            subNode.setPrev(looper);
            // In the above example, the prev for Subnode will point to the next of 3
            looper.setNext(subNode);
            // In the above example, we are setting the pointer fo rnext node for 3 to the prev pointer for 1.5
        }
    }
    public Object get(int index) throws IndexOutOfBoundsException
    {
        if(index > size || index < 0)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:  " + size);
        }
        else
        {
            DLNode looper = head; // forgot to create this variable, right though
            for(int i = 0; i <= index;i++)
            {
                looper = looper.getNext();

            }
            return looper.getValue();
        }

    }
    public Object remove(int index) throws IndexOutOfBoundsException   {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        else
        {   DLNode looper = head;
            // Set up loop correctly
            for(int i = 0; i<= index;i++)
            {
                looper = looper.getNext();
            }
            Object temp = looper.getValue();
            looper.getPrev().setNext(looper.getNext());
            looper.getNext().setPrev(looper.getPrev());
            return temp;
            // COMPLETELY CORRECT, 100% CREDIT
        }

    }
    public void addFirst(Object obj)
    {
        // Note: only got the first line right
        DLNode temp = new DLNode(obj,head,head.getNext());
        temp.setNext(temp);
        temp.getNext().setPrev(temp);
    }
    public void addLast(Object obj)
    {
        DLNode temp = new DLNode(obj,head,head.getNext()); // Keep this as head.getNext() for the next
        if(head == null)
        {   // Becuase there is nothing in the list
            head = temp;
            head.setNext(temp);
            head.setPrev(temp);
        }
        else
        {
            DLNode last = head.getPrev();
            temp.setPrev(last);
            temp.setNext(head); // NOTE: only head, not head.getPrev()
            last.setNext(temp);
            head.setPrev(temp); // forgot this line, remember it but also it is intuitive
        }
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
    public Object removeFirst()
    {
        if(head == null)
        {
            return null;
        }
        else
        {
            DLNode remover = head.getNext();
            remover.getPrev().setNext((remover.getNext())); // screwed up this line, remember it
            remover.getNext().setPrev(remover.getPrev());
            size--;
            return remover.getValue();
            // Good for the most part

        }
    }
    public Object removeLast()
    {
        if(head == null||size==0) // forgot this if statement a bit
        {
            return null;
        }
        else
        {
            DLNode remover = head.getNext();
            remover.getPrev().setNext(head); // Just dont blank on the test
            remover.getNext().setPrev(remover.getPrev());
            size--;
            return remover.getValue();
        }
    }
}
