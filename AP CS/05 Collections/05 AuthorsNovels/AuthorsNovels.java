//  Name: Aneesh Peri
//  Date: 1/2/24

import java.io.*;
import java.util.*;

public class AuthorsNovels
{
   public static void main(String[] args) throws IOException
   {
      /*   test the AuthorEntry object  */
      AuthorEntry a = new AuthorEntry("Aaa");
      System.out.println("name: " + a.getName());
      System.out.println("novels: " + a.getNovels());
      System.out.println("toString(): " + a);
      AuthorEntry b = new AuthorEntry("bbb", "y");
      System.out.println("name: " + b.getName());
      b.addNovel("z");
      b.addNovel("y");
      b.addNovel("x");
      System.out.println("novels: " + b.getNovels());
      System.out.println("toString(): " + b);
      System.out.println(b.compareTo(a));   // 1
      System.out.println(a.compareTo(b));   // -1
      System.out.println("AAA".compareTo(a.getName())); // 0


      /*  start the lab  */
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String inFileName = keyboard.nextLine().trim()+".txt";
      Scanner inputFile = new Scanner(new File(inFileName));
      //System.out.print("\nEnter output file name: ");
      //String outFileName = keyboard.nextLine().trim();
      AuthorList authors = readAndMakeTheList(inputFile);
      String outFileName = "authorsNovelsOut.txt";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outFileName));
      outputFile.println( authors.toString() );
      inputFile.close();
      outputFile.close();
      System.out.println("Done.");
      keyboard.close();
   }

   public static AuthorList readAndMakeTheList(Scanner inputFile)
   {
      AuthorList theList = new AuthorList();
      while(inputFile.hasNextLine())
      {
         theList.readOneLine(inputFile.nextLine());
      }
      return theList;
   }
}

class AuthorList extends ArrayList<AuthorEntry>
{
   /**   you get an ArrayList for free   **/
   public AuthorList()
   {
      super();
   }
   /** extracts the author and book from oneLine.
    calls addAuthorEntry
    */
   public void readOneLine(String oneLine)
   {
      String name = oneLine.substring(0, oneLine.indexOf(","));
      String book = oneLine.substring(oneLine.indexOf(",")+1);
      addAuthorEntry(name,book);
   }

   /** use a listIterator.  Needs to call .previous()
    either inserts a new AuthorEntry object, or
    adds a novel to a previous AuthorEntry object,
    in alphabetic order
    */
   public void addAuthorEntry(String name, String book)
   {
      ListIterator<AuthorEntry> li = this.listIterator();
      while (li.hasNext())
      {
         AuthorEntry current = li.next();
         if (current.getName().compareToIgnoreCase(name) == 0)
         {
            current.addNovel(book);
            return;
         }
         else if (current.getName().compareToIgnoreCase(name) > 0)
         {
            li.previous();
            li.add(new AuthorEntry(name, book));
            return;
         }
      }
      li.add(new AuthorEntry(name, book));
   }


   public String toString()
   {
      String append = "";
      for(AuthorEntry entry: this)
      {
         append += entry.toString() + "\n";
      }
      return append;
   }
}

class AuthorEntry implements Comparable<AuthorEntry>
{
   //fields
   private String name;
   private ArrayList<String> novels;

   //two constructors. argument n may be in lowercase.
   public AuthorEntry(String n)
   {
      name = n.toUpperCase();
      novels = new ArrayList<>();
   }
   public AuthorEntry(String n, String book)
   {
      name = n.toUpperCase();
      addNovel(book);
   }

   /**  appends book to novels, but only if it is not already in that list.
    */
   public void addNovel(String book)
   {
      if(novels == null)
      {
         novels = new ArrayList<>();
      }
      for(String novel : novels) {
         if(novel.equals(book)) {
            return;
         }
      }
      novels.add(book);
   }

   /** two standard accessor methods  */
   public String getName()
   {
      return name;
   }
   public ArrayList<String> getNovels()
   {
      return novels;
   }


   /**  pre:  name is not an empty string.  novels might be an empty ArrayList.
    uses:  either a for-each loop or an iterator
    post:  returns a string representation of this AuthorEntry in the format as
    shown on each line of the output file.
    */
   public String toString()
   {
      if(novels.isEmpty())
      {
         return name;
      }
      String appender = name+": "; // works because we made the name uppercase in the constructor
      for(String value: novels)
      {
         appender += value+", ";
      }
      return appender.substring(0,appender.length()-2);
   }

   @Override
   public int compareTo(AuthorEntry a) {
      return name.compareToIgnoreCase(a.getName());
   }
}


/***************************************
 Extension
 use this header to implement AuthorEntry a different way
 ***************************************************/
// class AuthorEntryExt extends ArrayList<String> implements Comparable<AuthorEntryExt>
// {
// }


/**********************  SAMPLE RUN  ********************************
 name: AAA
 novels: []
 toString(): AAA
 name: BBB
 novels: [y, z, x]
 toString(): BBB: y, z, x
 1
 -1
 0

 Enter input file name: infile2
 Done.

 **********************************************************/
/******** Output file for infile2:

 DOSTOEVSKI: Crime and Punishment, The Possessed, The Brothers Karamazov, The Grand Inquisitor
 FLAUBERT: Madame Bovary, A Simple Heart, Memoirs of a Madman, Sentimental Education
 STENDHAL: The Red and the Black
 TOLSTOY: Anna Karenina, War and Peace, The Death of Ivan Illyich, The Kreutzer Sonata

 */