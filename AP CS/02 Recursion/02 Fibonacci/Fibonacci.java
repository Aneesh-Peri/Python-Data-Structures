// Name: Aneesh Peri
// Date: 10/10/23
public class Fibonacci
{
   public static void main(String[] args)
   {
      long start, end, fib; //why long?
      int lastFibNumber = 43;
      int[] fibNumber = {1};
      System.out.println("\tFibonacci\tBy Iteration\tTime\tby Recursion\t Time");
      for(int n = fibNumber[0]; n <= lastFibNumber; n++)
      { 
         start = System.nanoTime();
         fib = fibIterate(n);
         end = System.nanoTime();
         System.out.print("\t\t" + n + "\t\t\t" + fib + "\t\t\t\t\t\t" + (end-start)/1000.);
         start = System.nanoTime();   	
         fib = fibRecur(n);      
         end = System.nanoTime();
         System.out.println("\t\t\t" + fib + "\t\t\t\t" + (end-start)/1000.);
      }
      System.out.println(fibRecur(2));
   }
   
   /**
    * Calculates the nth Fibonacci number by interation
    * @param n A variable of type int representing which Fibonacci number
    *          to retrieve
    * @returns A long data type representing the Fibonacci number
    */
   public static long fibIterate(int n)
   {
      int term1 = 1;
      int term2 = 1;
      int sum = 1;
      for(int i = 3; i <= n; i++)
      {
         sum = term1 + term2;
         term1 = term2;
         term2 = sum;
      }
      return sum;
   }
 
   /**
    * Calculates the nth Fibonacci number by recursion
    * @param n A variable of type int representing which Fibonacci number
    *          to retrieve
    * @returns A long data type representing the Fibonacci number
    */
   
   public static long fibRecur(int n)
   {
      if(n==0||n==1)
      {
         return n;
      }
      return fibRecur(n-1) + fibRecur(n-2);
   }
}