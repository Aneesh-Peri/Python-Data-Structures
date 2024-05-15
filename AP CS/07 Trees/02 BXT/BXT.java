// Name: 
// Date:  
/*  Represents a binary expression tree.
 *  The BXT builds itself from postorder expressions. It can
 *  evaluate and print itself.  Also prints inorder and postorder strings. 
 */
 
import java.util.*;

public class BXT
{
   public static final String operators = "+ - * / % ^ !";
   private TreeNode root;   
   
   public BXT()
   {
      root = null;
   }
   public TreeNode getRoot()   
   {
   
      return root;
   }
    
   public void buildTree(String str)
   {
     	Stack<TreeNode> stk = new Stack<TreeNode>();
      for(String value: str.split(" "))
      {
         if(!isOperator(value))
         {
            stk.push(new TreeNode(value));
         }
         else
         {
            TreeNode b = stk.pop();
            TreeNode a = stk.pop();
            TreeNode temporary = new TreeNode(value,a,b);
            stk.push(temporary);
         }
      }
      root=stk.pop();
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root); 
   }
   
   private double evaluateNode(TreeNode t)  //recursive
   {
      if(t.getLeft()==null&&t.getRight()==null)
      {
         return Double.parseDouble((String)t.getValue());
      }
      return computeTerm((String)t.getValue(),evaluateNode(t.getLeft()),evaluateNode(t.getRight()));
   }
   
   private double computeTerm(String s, double a, double b)
   {
      switch(s)
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
   
   private boolean isOperator(String s)
   {
      if(operators.contains(s))
      {
         return true;
      }
      return false;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
         
      toReturn += inorderTraverse(t.getLeft()); //recurse left
      toReturn += t.getValue() + " "; //process root
      toReturn += inorderTraverse(t.getRight()); //recurse right
      return toReturn;

   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode root)
   {
      String toReturn = "";
      if(root == null)
         return "";
      toReturn += root.getValue() + " ";              //process root
      toReturn += preorderTraverse(root.getLeft());   //recurse left
      toReturn += preorderTraverse(root.getRight());  //recurse right
      return toReturn;
   }
   
  /* extension */
   // public String inorderTraverseWithParentheses()
   // {
      // return inorderTraverseWithParentheses(root);
   // }
//    
   // private String inorderTraverseWithParentheses(TreeNode t)
   // {
      // return "";
   // }
}