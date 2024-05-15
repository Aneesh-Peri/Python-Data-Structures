public class Stack {


    private ListNode top;

    public void push(Object item)
    {
        top = new ListNode(item,top);
    }
    public Object pop()
    {
        try
        {
            Object value = top.getValue();
            top = top.getNext();
            return value;
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        return -1;
    }
    public Object peek()
    {
        if(top == null)
        {
            return null;
        }
        else {
            return top.getValue();
        }
    }
    public boolean isEmpty()
    {
        return top==null;
    }
    public String toString()
    {
        String start = "";
        ListNode starter = top;
        while(starter != null)
        {
            start = starter.getValue() + ", " + start;
            starter = starter.getNext();
        }
        if(start.isEmpty())
        {
            return "[]";
        }
        return "[" + start.substring(0,start.length()-2) + "]";
    }
}
