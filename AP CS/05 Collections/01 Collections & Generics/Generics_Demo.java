//name: Aneesh Peri date: 12/12/23
import java.util.*;

public class Generics_Demo
{
   public static void main(String[] args)
   {
   /*************  non-generic data structures **********************/
   
      List myList = new ArrayList();          //old style, non-generic
      myList.add("this is a string");         //put a String in the arrayList
      // String str = myList.get(0);           //error: ____________________________________________
      
      //_________________________________________//Fix it by changing the type of the reference.


      //________________________________________ //Fix it by casting. It now acts like a String.
      //String str = (String) myList.get(0);


      //________________________________________ //another way to cast.
      
      //_________________________________________//Stack Overflow's way to change obj to a String
      
      //________________________________________ //every Object has a toString()
      //System.out.println( str );
   
      List theList = new ArrayList();         //old style, non-generic
      theList.add(3);                         //put an int in the arrayList    
      //int x = theList.get(0);          //error: _____________________________________
      
      //__________________________________//Fix it by changing the type of the reference.
   
      //__________________________________//Fix it by casting.
      int x = (int) theList.get(0);

      //_________________________________ //Stack Overflow's way to change obj to an Integer
      
      //__________________________________//every Object has a toString()
     
      // int square = x * x;              // it behaves like an Integer
      // System.out.println( square );
      
      
    /*************  generic data structures  **********************/  
     
      List<String> stringList = new ArrayList<>();  // ArrayList<E>
      stringList.add("this is a string");
      String str2 = stringList.get(0);       //it "remembers" the data is a String
      String str3 = str2.substring(1,2);     //all String methods are available without casting
      System.out.println( str3 );
      
      LinkedList<Integer> ints = new LinkedList<>();  // LinkedList<E>
      ints.add(3);
      Integer y = ints.getFirst();          //it "remembers" the data is an Integer
      Integer square = y * y;               //no need to cast
      System.out.println( square );
   
   /*************  ListNode  **********************/   
   
      ListNode<Integer> s = new ListNode<>(4, null);   //uses the generic ListNode<E>, see below
      ListNode<Integer> t = new ListNode<>(5, s);
      Integer num = (Integer) t.getNext().getValue();            //what type does getNext() return?
      Integer sq = num * num;                    
      System.out.println( sq );
   }

   static class ListNode<E>     //write the generic ListNode<E> class
   {
   /*  two private fields  */
   private Object value;
   private ListNode next;
      
   /* one two-arg constructor  */
   public ListNode(Object v, ListNode n)
   {
      value=v;
      next=n;
   }
      
         
         
      
   /*  2 accessor methods   */
   public Object getValue()
   {
      return value;
   }
   public ListNode getNext()
   {
      return next;
   }
   public void setValue(Object newv)
   {
      value=newv;
   }
      public void setNext(ListNode newn)
      {
         next=newn;
      }
   }
}
   
   
 /***************************
   ----jGRASP exec: java Generics_Demo
 h
 9
 16
 
 ***************************/