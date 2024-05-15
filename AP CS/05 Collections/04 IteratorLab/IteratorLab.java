 // Name:      
 // Date:
 // use for-each loops or iterators, not regular for-loops
import java.util.*;
public class IteratorLab
{
   public static void main(String[] args)
   {
      System.out.println("Iterator Lab\n");
      
      int[] rawanimals = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
      for(int n : rawanimals )
         System.out.print(n + " ");    
      ArrayList<Integer> animals = createanimals(rawanimals);
      System.out.println("\nArrayList: "+ animals);      //Implicit Iterator!
      System.out.println("Count negative animals: " + countNeg(animals));
      System.out.println("Average: " + average(animals));
      replaceNeg(animals);
      System.out.println("Replace negative animals: " + animals);
      deleteZero(animals);
      System.out.println("Delete zeros: " + animals);
      String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
      ArrayList<String> movies = createMovies(rawMovies);
      System.out.println("Movies: " + movies);
      System.out.println("Movies: " +  removeDupes(movies));
   }
      // pre: an array of int values 
   	// post: return an ArrayList containing all the values
   public static ArrayList<Integer> createanimals(int[] rawanimals) 
   {
      ArrayList<Integer> myList = new ArrayList<Integer>();
      for ( int val: rawanimals )
         myList.add(val);
      return myList;
   }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
   public static ArrayList<String> createMovies(String[] rawWords) 
   {
      ArrayList<String> myList = new ArrayList<String>();
      for ( String str : rawWords )
         myList.add( str );
      return myList;
   }
   
   	// pre: ArrayList A is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
   public static int countNeg(ArrayList<Integer> a)
   {
         ListIterator<Integer> iterator = a.listIterator();
         int counter  = 0;
         while(iterator.hasNext())
         {
            if(iterator.next()<0)
            {
               counter++;
            }
         }
         return counter;

   }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
   public static double average(ArrayList<Integer> a)
   {
       int length = 0;
       double sum = 0;
       for (Integer integer : a) {
           sum += integer;
           length++;
       }
       return sum/length;
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
   public static void replaceNeg(ArrayList<Integer> a)
   {
      ListIterator<Integer> iterator = a.listIterator();

      while(iterator.hasNext())
      {
         if(iterator.next()<0)
         {
            iterator.set(0);
         }
      }

   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
   public static void deleteZero(ArrayList<Integer> a)
   {
      ListIterator<Integer> iterator = a.listIterator();
      
      while(iterator.hasNext())
      {
         if(iterator.next()==0)
         {
            iterator.remove();
         }
      }
   }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return a new ArrayList without duplicate movie titles
      //       the parameter a is not modified!
		// strategy: start with an empty array and add movies as needed
   public static ArrayList<String> removeDupes(ArrayList<String> a)
   {
      ArrayList<String> finalList  = new ArrayList<>();
      for(String movies: a)
      {
         if(!finalList.contains(movies))
         {
            finalList.add(movies);
         }
      }
      return finalList;
   }
}

