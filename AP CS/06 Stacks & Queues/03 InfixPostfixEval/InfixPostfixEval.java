// Name:
// Date:
//uses PostfixEval

import java.util.*;
public class InfixPostfixEval
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   public static final String operators = "+ - * / % ^ !";
   
   public static void main(String[] args)
   {
      System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
      /*build your list of Infix expressions here  */
      List<String> infixExp = new ArrayList<>();
      infixExp.add("( 33 + -43 ) * ( -55 + 65 )");      
         
      for( String infix : infixExp )
      {
         try{
            String pf = infixToPostfix(infix);  //get this conversion to work first
            //System.out.println(infix + "\t\t\t" + pf );  
            System.out.println(infix + "\t\t\t" + pf + "\t\t\t" + PostfixEval.eval(pf));  //PostfixEval must work!
         }
         catch(Exception e)
         {
            System.out.println(e.toString());
         } 
      }
   }
   
   public static String infixToPostfix(String infix)
   {
      List<String> nums = new ArrayList<String>(Arrays.asList(infix.split(" ")));
      Stack<String> stk = new Stack<String>();
      String result = "";
            /* enter your code here  */
       for(String value: nums)
       {
          if(LEFT.contains(value))
          {
            stk.push(value);
          }
          else if(RIGHT.contains(value))
          {
            while(!LEFT.contains(stk.peek()))
            {
               result += stk.pop() + " ";
            }
            stk.pop();
          }
          else if(!operators.contains(value))
          {
             result += value + " ";
          }

          else
          {
             while(!stk.isEmpty() && !isStrictlyLower(value,stk.peek()))
                {
                  result = result + stk.pop() + " ";
                }
             stk.push(value);
          }
       }
       while(!stk.isEmpty())
       {
         result += stk.pop() + " ";
       }
       return result.trim(); 

   }
   
   
   //enter your precedence method below
   public static boolean isStrictlyLower(String next, String top)
   {
      int one = getLevel(next);
      int two = getLevel(top);
      return two < one;
   }
   public static int getLevel(String operator)
   {  
      int value = 0;
      if(operator.equals("+") || operator.equals("-"))
         value = 1;
      if(operator.equals("*") || operator.equals("/") ||operator.equals("%"))
         value = 2;
      if(operator.equals("^"))
         value = 3;
      if(operator.equals("!"))
         value = 4;
      return value;
   }
}
/********************************************

Infix  	-->	Postfix		-->	Evaluate
 5 - 1 - 1			5 1 - 1 -			3.0
 5 - 1 + 1			5 1 - 1 +			5.0
 12 / 6 / 2			12 6 / 2 /			1.0
 3 + 4 * 5			3 4 5 * +			23.0
 3 * 4 + 5			3 4 * 5 +			17.0
 1.3 + 2.7 + -6 * 6			1.3 2.7 + -6 6 * +			-32.0
 ( 33 + -43 ) * ( -55 + 65 )			33 -43 + -55 65 + *			-100.0
 8 + 1 * 2 - 9 / 3			8 1 2 * + 9 3 / -			7.0
 3 * ( 4 * 5 + 6 )			3 4 5 * 6 + *			78.0
 3 + ( 4 - 5 - 6 * 2 )			3 4 5 - 6 2 * - +			-10.0
 2 + 7 % 3			2 7 3 % +			3.0
 ( 2 + 7 ) % 3			2 7 + 3 %			0.0
      
***********************************************/
