//  name:
// date:

import java.io.*;
import java.util.*;

public class AuthorsNovelsMap
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String inFileName = keyboard.nextLine().trim()+".txt";
      Scanner inputFile = new Scanner(new File(inFileName));
      //System.out.print("\nEnter output file name: ");
      //String outFileName = keyboard.nextLine().trim();
   
      AuthorsMap authors = readAndMakeTheList(inputFile);
      PrintWriter outputFile = new PrintWriter(new FileWriter("authorsNovelsOut.txt"));
      outputFile.println( authors.toString() );
      inputFile.close(); 						
      outputFile.close();
      System.out.println("File created.");
   }
   
   public static AuthorsMap readAndMakeTheList(Scanner inputFile)
   {
      AuthorsMap theAuthors = new AuthorsMap();
      while(inputFile.hasNextLine())
      {
         theAuthors.readOneLine(inputFile.nextLine());
      }
      return theAuthors;
   }
}

class AuthorsMap extends TreeMap<String, Set<String>>
{
  /**   when you extend a class, the constructor is optional  **/

    
   /** extracts the author and book from oneLine.
       calls addAuthorOrNovel      
      */
   public void readOneLine(String oneLine) 
   { 
      String name = oneLine.substring(0, oneLine.indexOf(","));
      String book = oneLine.substring(oneLine.indexOf(",")+1);
      addAuthorOrNovel(name,book);
   }
   
   /**  either inserts a new Author mapping, or updates a previous Author mapping
        */
   @SuppressWarnings({ "rawtypes", "unchecked" })
   public void addAuthorOrNovel(String name, String book)
   {  // adding to a TreeSet in this method in else statement
      name = name.toUpperCase();
      if(!containsKey(name))
      {
         put(name,new TreeSet());  
         get(name).add(book); 
      }
      else
      {
         get(name).add(book);
      }
   }
   
   public String toString()
   {  
     String stringer="";
     for(String value: keySet())
     {
       stringer += value.toUpperCase()+": ";
       for(String val: get(value))
       {
         stringer += val+", ";
       }
       stringer = stringer.substring(0,stringer.length()-2)+"\n";
     }
     return stringer;
   }
}
   

/**********************  SAMPLE RUN  ********************************
   /******** Output file for infile2:
   
   DOSTOEVSKI: Crime and Punishment, The Possessed, The Brothers Karamazov, The Grand Inquisitor
   FLAUBERT: Madame Bovary, A Simple Heart, Memoirs of a Madman, Sentimental Education
   STENDHAL: The Red and the Black
   TOLSTOY: Anna Karenina, War and Peace, The Death of Ivan Illyich, The Kreutzer Sonata
   
    **********************************/