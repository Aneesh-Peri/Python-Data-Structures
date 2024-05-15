// Name:
// Date:

import java.util.*;
import java.lang.Math;

public class PostfixEval
{
   public static final String operators = "+ - * / % ^ !";
   
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postfixExp = new ArrayList<String>();
      /*  build your list of expressions here  */
      postfixExp.add("1 1 1 1 1 + + + + !");
      
   
      
      for( String pf : postfixExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   
   public static double eval(String pf)
   {
      List<String> postfixParts = new ArrayList<String>(Arrays.asList(pf.split(" ")));
      Stack<Double> stk = new Stack<Double>();
      /*  enter your code here  */
      for(String s:postfixParts)
      {
         if(!operators.contains(s))
         {
            stk.push(Double.parseDouble(s));
         }
         else if(operators.contains(s))
         {  
            if(s.equals("!"))
            {
               double popper = stk.peek();
               System.out.println(popper);
               double value = popper;
               for(double i = popper-1; i>=1;i--)
               {
                  value *= i;
               }
               System.out.println(value);
               stk.push(value);
            }
            else
            {
            
            Double b = stk.pop();
            Double a = stk.pop();
            stk.push(eval(a,b,s)); 
            }
         }
      }
      return stk.pop();
      
   
   }
   
   public static double eval(double a, double b, String op)
   {
      switch(op)
      {
         case "+":
            return a + b;
         case "-":
            return a - b;
         case "*":
            return a * b;
         case "/":
            return a/b;
         case "%":
            return a % b;
         case "^":
            return Math.pow(a,b);   
        
             
      }
      return 1;
   }
   
   public static boolean isOperator(String op)
   {
      return operators.contains(op);
   }
}

/**********************************************
Postfix  -->  Evaluate
 3 4 5 * +		23
 3 4 * 5 +		17
 10 20 + -6 6 * +		-6
 3 4 + 5 6 + *		77
 3 4 5 + * 2 - 5 /		5
 8 1 2 * + 9 3 / -		7
 2 3 ^		8
 20 3 %		2
 21 3 %		0
 22 3 %		1
 23 3 %		2
 5 !		120
 1 1 1 1 1 + + + + !		120
 
 
 *************************************/