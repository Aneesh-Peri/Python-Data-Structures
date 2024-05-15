// Name: Aneesh Peri
// Date: 10/5/23
  
import java.util.*;
public class Permutations
{
   public static int count = 0;
    
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.println(goFigure(60));
      System.out.print("\nHow many digits? ");
      int n = sc.nextInt();
      leftRight("", n);  
              
      oddDigits("", n);
      
      superprime(n);
      if(count==0)
         System.out.println("no superprimes");
      else
         System.out.println("Count is "+count);
      sc.close();
   }
   
    /**
     * Builds all the permutations of a string of length n containing Ls and Rs
     * @param s A string 
     * @param n An postive int representing the length of the string
     */
   public static void leftRight(String s, int n)
   {
      if(n==0)
      {
         System.out.println(s);
      }
      else
      {
         leftRight(s+"L", n-1);
         leftRight(s+"R", n-1);
      }
   }
   
    /**
     * Builds all the permutations of a string of length n containing odd digits
     * @param s A string 
     * @param n A postive int representing the length of the string
     */
   public static void oddDigits(String s, int n)
   {  
      if(n==0)
      {
         System.out.println(s);
      }
      else
      {  
         oddDigits(s+"1",n-1);
         oddDigits(s+"3",n-1);
         oddDigits(s+"5", n-1);
         oddDigits(s+"7", n-1);
         oddDigits(s+"9", n-1);
      }
   }
      
    /**
     * Builds all combinations of a n-digit number whose value is a superprime
     * @param n A positive int representing the desired length of superprimes  
     */
   public static void superprime(int n)
   {
      recur(2, n); //try leading 2, 3, 5, 7, i.e. all the single-digit primes
      recur(3, n); 
      recur(5, n);
      recur(7, n);
   }
 
    /**
     * Recursive helper method for superprime
     * @param k The possible superprime
     * @param n A positive int representing the desired length of superprimes
     */
   private static void recur(int k, int n)
   { 
      if(n==0)
      {  
         System.out.println(k);
      }
      else if(n==1)
      {
         System.out.println(k);
         count++;
         return;
      }
	  else
      {
        if(isPrime(k))
        {
          for(int i = 1; i <= 9; i++)
          { 
            if((i == 1 || i == 3|| i == 5|| i == 7||i==9)&&isPrime((k*10)+i))
            {  
               recur((k*10)+i,n-1);
            }
          }
        }
      }
 
   }
 
    /**
     * Determines if the parameter is a prime number.
     * @param n An int.
     * @return true if prime, false otherwise.
     */
    public static int goFigure( int x )

    {

       if( x < 100 )
       {
         System.out.println(x);
         x = goFigure(x + 10);
         System.out.println(x);
       }
       System.out.println(x-1);
       return (x-1);

        }
    
   public static boolean isPrime(int n)
   {  
      if(n<=1)
      {
         return false;
      }
      else{
 
      for(int i = 2; i <n/2;i++)
      {
         if(n%i==0)
         {
            return false;
         }
      }
      return true;
   }
   }
}