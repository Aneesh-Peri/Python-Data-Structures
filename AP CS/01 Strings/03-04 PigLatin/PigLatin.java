// Name:   
// Date: 
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
      part_1_using_pig();
      // part_2_using_piglatenizeFile();
      
      /*  extension only    */
      // String pigLatin = pig("What!?");
      // System.out.print(pigLatin + "\t\t" + pigReverse(pigLatin));   //Yahwta!?
      // pigLatin = pig("{(Hello!)}");
      // System.out.print("\n" + pigLatin + "\t\t" + pigReverse(pigLatin)); //{(Yaholle!)}
      // pigLatin = pig("\"McDonald???\"");
      // System.out.println("\n" + pigLatin + "  " + pigReverse(pigLatin));//"YaDcmdlano???"
   }

   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in); //input from the keyboard
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();     //reads up to white space
         if(s.equals("-1"))
         {
            System.out.println("Goodbye!"); 
            System.exit(0);
         }
         String p = pig(s);
         System.out.println( p );
      }		
   }

   public static final String punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()";
   public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   public static final String vowels = "AEIOUaeiou";
   public static String pig(String s)
   {
      int prepunct = 0;
      int endpunct = 0;
      if(s.length() == 0)
         return "";
      //remove and store the beginning punctuation 
      // for(int i = 0; i < s.length(); i++)
      // {
      //    if(punct.contains(s.charAt(i)+""))
      //    {
      //       prepunct = i;
      //    }
      //    else if(punct.contains(s.charAt(s.length()-i)+""))
      //    {
      //       endpunct = (s.length()-i);;
      //    }
      //    else
      //    {
      //       prepunct = 0;
      //       endpunct = 0;
      //    }
      // }
      // String stringer = s.substring(1,s.length()-1);

           
      //remove and store the ending punctuation 
         
         
      //START HERE with the basic case:
      //     find the index of the first vowel
      //     y is a vowel if it is not the first letter

      // The followig code works for basic rules, special cases

      int index = -1;
      String str = "";
      
      for(int i = s.length()-1; i >= 0; i--)
      {
         for(int j = 0; j < vowels.length(); j++)
         {
            // checking for qu below
            if(s.charAt(i) == 'q' && s.charAt(i+1) == 'u' )
            {
               index = i;
               return s.substring(index+2) + s.substring(0,index+2) + "ay";
               
            }
            else if(s.charAt(0) == 'y')
            {
               index = 0;
               return s.substring(1) + s.substring(0,index+1) + "ay";
            }
            else if(s.charAt(0) == vowels.charAt(j))
            {
               index = i;
               return s + "way";
            }
            else if(s.charAt(i) == vowels.charAt(j))
            {
               index = i;
               break;
            }

         }
      }
      if(index == -1)
      {
         return "**** NO VOWEL ****";
      }
      
      // Checking if the first letter is capitalized and doing respective actions
      for(int i = 0; i < s.length(); i++)
      {
            if(Character.isUpperCase(s.charAt(0)) && !vowels.contains(Character.toString(s.charAt(0))))
            {
               String newString = s.substring(index) + s.substring(0,index) + "ay";
               newString = newString.toLowerCase();
               char firstLetter = Character.toUpperCase(newString.charAt(0));
               return firstLetter + s.substring(index+1) + Character.toLowerCase(s.charAt(0)) + s.substring(1,index) + "ay";  
            }

      } 

      
      

      //return the piglatinized word 
      return s.substring(index) + s.substring(0,index) + "ay";
      
      
   }


   public static void part_2_using_piglatenizeFile() 
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("input filename including .txt: ");
      String fileNameIn = sc.next();
      System.out.print("output filename including .txt: ");
      String fileNameOut = sc.next();
      piglatenizeFile( fileNameIn, fileNameOut );
      System.out.println("Piglatin done!");
   }

/****************************** 
*  piglatinizes each word in each line of the input file
*    precondition:  both fileNames include .txt
*    postcondition:  output a piglatinized .txt file 
******************************/
   public static void piglatenizeFile(String fileNameIn, String fileNameOut) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(fileNameIn));  
      }
      catch(IOException e)
      {
         System.out.println("oops");
         System.exit(0);   
      }
   
      PrintWriter outfile = null;
      try
      {
         outfile = new PrintWriter(new FileWriter(fileNameOut));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
   	//process each word in each line
      
      infile.useDelimiter(" ");
      
   
      outfile.close();
      infile.close();
   }

   
   /** EXTENSION: Output each PigLatin word in reverse, preserving before-and-after 
       punctuation.  
   */
   public static String pigReverse(String s)
   {
      if(s.length() == 0)
         return "";
         
      return "";   //just to compile   
   }
}