// Name: Aneesh Peri
// Date: October 1, 2023
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;


public class Cemetery
{
   public static void main (String [] args) throws Exception
   {
      File file = new File("cemetery_short.txt");
      //File file = new File("cemetery.txt");
      int numEntries = countEntries(file);
      System.out.println(numEntries);
      Person[] cemetery = readIntoArray(file, numEntries); 
      for (int i = 0; i < cemetery.length; i++) 
      {
         System.out.println(cemetery[i]);
      }   
      int min = locateMinAgePerson(cemetery);
      int max = locateMaxAgePerson(cemetery); 
      // System.out.println(min);
      // System.out.println(max);
      System.out.println("\nIn the St. Mary Magdelene Old Fish Cemetery: ");
      System.out.println("Name of youngest person: " + cemetery[min].getName());
      System.out.println("Age of youngest person: " + cemetery[min].getAge());    
      System.out.println("Name of oldest person: " + cemetery[max].getName());
      System.out.println("Age of oldest person: " + cemetery[max].getAge()); 
      //you may create other testing cases here
     
          
   }
   
   /* Counts and returns the number of entries in File f. 
      Returns 0 if the File f is not valid.
      Uses a try-catch block.   
      @param f -- the file object
   */
   public static int countEntries(File f) throws Exception
   {  
      
      int counter = 0;
      try(Scanner filereader = new Scanner((f)))
      {
         while(filereader.hasNextLine())
         {
            counter ++;
            filereader.nextLine();
         }
      }
      catch(Exception e)
      {
         System.out.println("Oops, you can't run this method!" + e);
      }
      return counter;
      
   }

//    /* Reads the data from file f (you may assume each line has same allignment).
//       Fills the array with Person objects. If File f is not valid return null.
//       @param f -- the file object 
//       @param num -- the number of lines in the File f  
//    */
   public static Person[] readIntoArray (File f, int num){
   
      Person[] values = new Person[num];
      try{Scanner scan = new Scanner(f);
         for(int i = 0; i < num; i++){
         {
            values[i] = makeObjects(scan.nextLine());
         }
      }
      }
         catch(Exception e)
         {
            System.out.println("Error occuring" + e);
            return null;
         }
      return values;
}
   
//    /* A helper method that instantiates one Person object.
//       @param entry -- one line of the input file.
//       This method is made public for gradeit testing purposes.
//       This method should not be used in any other class!!!
//    */
   public static Person makeObjects(String entry)
   {     
         entry.trim(); // Assign the trimmed entry back to the variable
         String name = entry.substring(0, 25);
         String burialDate = entry.substring(25, 36);
         String combinedString = entry.substring(37);
         int index = combinedString.indexOf(" ");
         String age = combinedString.substring(0,index);
         return new Person(name,burialDate,age);
   }  

//    /* Finds and returns the location (the index) of the Person
//       who is the youngest. (if the array is empty it returns -1)
//       If there is a tie the lowest index is returned.
//       @param arr -- an array of Person objects.
//    */
   public static int locateMinAgePerson(Person[] arr)
   {  
     int index = 1;
     for(int i = 0; i < arr.length; i++)
     {
         if(arr[i].getAge() < arr[index].getAge())
         {
            index = i;
         }
     }
     return index;
   }   
   
//    /* Finds and returns the location (the index) of the Person
//       who is the oldest. (if the array is empty it returns -1)
//       If there is a tie the lowest index is returned.
//       @param arr -- an array of Person objects.
//    */
   public static int locateMaxAgePerson(Person[] arr)
   {
     int index = 0;
     for(int i = 0; i < arr.length; i++)
     {
         if(arr[i].getAge() > arr[index].getAge())
         {
            index = i;
         }
         else
         {
            continue;
         }
     }
     return index;
   }

} 
 

class Person
{
   private double age;
   private String name;
   private String burialdate;
   //    //constant that can be used for formatting purposes
   //    private static final DecimalFormat df = new DecimalFormat("0.0000");
   //    /* private fields */
      
         
   //    /* a three-arg constructor  
   //     @param name, burialDate may have leading or trailing spaces
   //     It creates a valid Person object in which each field has the leading and trailing
   //     spaces eliminated*/
   public Person(String nam, String burialDat, String ag)
   {
      age = calculateAge(ag);
      name = nam;
      burialdate = burialDat;
   }
   //    /* any necessary accessor methods (at least "double getAge()" and "String getName()" )
   //    make sure your get and/or set methods use the same data type as the field  */
   public double getAge()
   {
      return age;
   }
   public String getName()
   {
      return name;
   }
   public String toString()
   {
      return getName() + ", " + burialdate + ", " + getAge();
   }
   
//    /*handles the inconsistencies regarding age
//      @param a = a string containing an age from file. Ex: "12", "12w", "12d"
//      returns the age transformed into year with 4 decimals rounding
//    */
   public double calculateAge(String a)
   {  
      double value1 = 0;
      double value2 = 0;
      if(a.contains("w"))
      {
         a=a.replace("w", "");
         value1 = (Double.parseDouble(a)*7)/365;
         value2 = (Math.round(value1*10000.0)/10000.0);
      }
      else if(a.contains("d"))
      {
        a= a.replace("d", "");
         value1 =(Double.parseDouble(a))/365.0;
         value2 = (Math.round(value1*10000.0)/10000.0);
      }
      else if(a.contains("."))
      {
         value2 = Double.parseDouble(a);
      }
      else
      {
         value2 = Double.parseDouble(a);

      }
      return value2;
   }
}



/******************************************

 John William ALLARDYCE, 17 Mar 1844, 2.9
 Frederic Alex. ALLARDYCE, 21 Apr 1844, 0.17
 
 Thomas ANDERSON, 06 Jul 1845, 27.0
 Edward ANGEL, 20 Nov 1842, 22.0
 Lucy Ann COLEBACK, 23 Jul 1843, 0.2685
 Thomas William COLLEY, 08 Aug 1833, 0.011
 Joseph COLLIER, 03 Apr 1831, 58.0
 
 In the St. Mary Magdelene Old Fish Cemetery --> 
 Name of youngest person: Thomas William COLLEY
 Age of youngest person: 0.011
 Name of oldest person: Joseph COLLIER
 Age of oldest person: 58.0
 
 **************************************/