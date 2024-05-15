// Name:  
// Date: 
  
public class Sentence
{
   private String mySentence;
   private int myNumWords;
   
   //Precondition:  str is not empty.
   //               Words in str separated by exactly one blank.
   public Sentence( String str )
   { 
      mySentence = str;
      String[] words = str.split(" ");
      myNumWords = words.length;
      
   }
   
   public int getNumWords()
   {  
      return myNumWords;  
   }
   
   public String getSentence()
   {
      return mySentence; 
   }
   
   //Returns true if mySentence is a palindrome, false otherwise.
   //calls the 3-arg isPalindrome(String, int, int)
   public boolean isPalindrome()
   {
      boolean value = isPalindrome(mySentence,0,getSentence().length()-1);
      return value;
   }
   //Precondition: s has no blanks, no punctuation, and is in lower case.
   //Recursive method.
   //Returns true if s is a palindrome, false otherwise.
   public static boolean isPalindrome(String s, int start, int end)
   {  
      s.toLowerCase();
      if(start >= end)
      {
         return true;
      }
      else if(s.charAt(start) != s.charAt(end))
      {
         return false;
      }
      else
      {
         return isPalindrome(s, start+1, end-1);
      }
      
   }
   //Returns copy of String s with all blanks removed.
   //Postcondition:  Returned string contains just one word.
   public static String removeBlanks( String s )
   {  
      return s.replaceAll(" ", "");
   }
   
   //Returns copy of String s with all letters in lowercase.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   public static String lowerCase( String s )
   {  
      return s.toLowerCase();
   }
   
   //Returns copy of String s with all punctuation removed.
   //Postcondition:  Number of words in returned string equals
   //						number of words in s.
   public static String removePunctuation(String s)
   { 
      String punct = ".,'?!:;\"(){}[]<>"; 
      String str = "";
      for(int i = 0; i < s.length(); i++)
      {  
         String value = Character.toString(s.charAt(i));
         if(punct.contains(value) == false)
         {
            str += value;
         }
      }
      return str;
      
   }
}