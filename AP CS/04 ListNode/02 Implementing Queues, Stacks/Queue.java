public class Queue {

    private ListNode first;
    private ListNode last;


    public void add(Object obj)
    {
        if(first == null)
        {
            ListNode newListNode = new ListNode(obj,null);
            first = newListNode;
            last = newListNode;
        }
        else
        {
            last.setNext(new ListNode(obj,null));
            last = last.getNext();
        }

    }
    public Object remove()
    {
        if(first == null||last==null)
        {
            return null;
        }
        else
        {
            Object value = first.getValue();
            first = first.getNext();
            return value;

        }
    }
    public Object peek()
    {
        if(first == null)
        {
            return null;
        }
        else {
           return first.getValue();
        }
    }
    public boolean isEmpty()
    {
        return first==null;
    }
    public String toString()
    {
        String start = "[";
        ListNode starter = first;
        while(starter != null)
        {
            start = start + starter.getValue();
            starter = starter.getNext();
            if (starter != null) {
                start += ", ";
            }
        }
        start += "]";
        return start;
    }

}
