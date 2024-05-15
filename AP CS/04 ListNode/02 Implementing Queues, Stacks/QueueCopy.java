public class QueueCopy {

    private ListNode first;
    private ListNode last;

    // FAIL: Wasn't able to do first if statement without referring back to previous code
    public void add(Object obj)
    {
        if(first== null)
        {
            ListNode copy = new ListNode(obj,null);
            first = copy;
            last = copy;
        }
        else
        {
            ListNode ender = new ListNode(obj,null);
            last.setNext(ender);// Error here was that I used first instead of last. We use last because it is at END of queue, and last represents last
            last = last.getNext();
        }
    }
    public Object remove()
    {
        if(first == null)
        {
            return null;
        }
        else
        {
            // Error: reading the problem wrong
            Object value = first.getValue();
            first = first.getNext();
            return value;
        }
    }
    // CORRECT
    public Object peek()
    {
        if(first == null)
        {
            return null;
        }
        else
        {
            return first.getValue();
        }
    }
    public boolean isEmpty()
    {
        if(first == null)
        {
            return  true;
        }
        return false;
    }
    public String toString()
    {
        String starter = "[";
        ListNode index = first;
        if(first == null)
        {
            return null;
        }
        else
        {
            starter += index.getValue();
            index = index.getNext(); // forgot this part of hte line
            if(index!=null)
            {
                starter += ", ";
            }
        }
        return starter;
    }
}
