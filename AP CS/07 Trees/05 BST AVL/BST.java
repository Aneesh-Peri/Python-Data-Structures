// Name: 
// Date: 
 
interface BSTinterface
{
   public int size();
   public TreeNode getRoot() ;
   public boolean contains(String obj);
   public void add(String obj);          //does not balance
   public void addBalanced(String obj);  //AVL
   public void remove(String obj);       //does not re-balance
   //public void removeBalanced(String obj); //extension
   public String min();
   public String max();
   public String display();
   public String toString();
}
 
public class BST implements BSTinterface
{
   /*  copy your BST code  here  */
  
   private TreeNode root;
   private int size;
   public BST()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
     return size;
   }
   public TreeNode getRoot()   //accessor method
   {
      return root;
   }
   /***************************************
   @param s -- one string to be inserted
   ****************************************/
   public void add(String s) 
   {
      size++;
      root = add(root, s);
   }
   private TreeNode add(TreeNode t, String s) //recursive helper method
   {      
      if(t==null)
      {
         return new TreeNode(s);  
      }
      if(((String)t.getValue()).compareTo(s)>=0)
      {
            t.setLeft(add(t.getLeft(),s));
      }
      else if(((String)t.getValue()).compareTo(s)<=0)
      {
            t.setRight(add(t.getRight(),s));
      }
      
      return t; 
   }
     /*************************
      Copy the display() method from TreeLab. 
      **********************/
   public String display()
   {
       return display(root, 0);
   }
   private String display(TreeNode t, int level) //recursive helper method
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
   
   public boolean contains( String obj)
   {
      return contains(root,obj);
   }
   private boolean contains(TreeNode t, String x) //recursive helper method
   {
      if(t==null)
      {
         return false;
       }
      if(((String)t.getValue()).compareTo(x)==0)
      {
         return true;
      }
      else if(((String)t.getValue()).compareTo(x)<0)
      {
         return contains(t.getRight(),x);
      }
         return contains(t.getLeft(),x);     
   }
   
   public String min()
   {
      return min(root);
   }
   private String min(TreeNode t)  //use iteration
   {
      if( t == null )
         return null;
      if(t.getLeft()==null)
      {
         return (String)t.getValue();
      }
      return min(t.getLeft());
   }
   
   public String max()
   {
      return max(root);
   }
   private String max(TreeNode t)  //recursive helper method
   {
      if( t == null )
         return null;
      if(t.getRight()==null)
      {
         return (String)t.getValue();
      }
      return max(t.getRight());
   }
   
   public String toString()
   {
      return toString(root);
   }
   private String toString(TreeNode t)  //an in-order traversal.  Use recursion.
   {
      String toReturn = "";
      if(t == null)
         return "";
         
      toReturn += toString(t.getLeft()); //recurse left
      toReturn += t.getValue() + " "; //process root
      toReturn += toString(t.getRight()); //recurse right
      return toReturn;
   }
 
   /*  precondition:  target must be in the tree.
                      implies that tree cannot be null.
   */
   public void remove(String target)
   {
      root = remove(root, target);
      size--;
   }
   private TreeNode remove(TreeNode current, String target)
   {     
      if(current == null)
         return null;
      String value = (String)(current.getValue());
      if(value.equals(target)) // found the target
      {
         if(current.getLeft()==null&&current.getRight()==null) // checking if this is a leaf node
         {
            return null;
         }
         else if(current.getLeft()!=null && current.getRight()==null) // checking if t has only a left child
         {
            return current.getLeft();
         }
         else if(current.getLeft()==null && current.getRight()!=null) // checking if t has only a right child
         {
            return current.getRight();
         }
         else
         {
            String highestVal = max(current.getLeft()); // find biggest value in left subtree
            current.setValue(highestVal);
            current.setLeft(remove(current.getLeft(),highestVal)); // removing maxVal from left subtree
            return current;
         }
      }
      else if(target.compareTo(value)<0) // target is smaller
      {
         current.setLeft(remove(current.getLeft(),target)); // update left subtree
      }
      else
      {
         current.setRight(remove(current.getRight(),target));
      }
      return current; // return the tree
   }
 
 
 
 
   /*  start the addBalanced methods */
   private int calcBalance(TreeNode current) //height to right minus 
   {                                         //height to left
      return height(current.getRight()) - height(current.getLeft());
   }
 
  private int height(TreeNode current)   //from TreeLab
   {
       if(current==null)
           return -1;
       if(current.getLeft() == null && current.getRight() == null)
           return 0;
       else
           return Math.max(1+height(current.getLeft()),1+height(current.getRight()));
   }
   
 
   public void addBalanced(String value)  
   {
      root = addBalanced(root,value);
      size++;
   /*
      // first approach
      add(value);
      root = balanceTree( root );
   */
      
   /*
      // second approach
      root = addBalanced(root, value);
   */
   }
   
   //helper method for second approach
   private TreeNode addBalanced(TreeNode t, String obj)
   {
      if (t == null) {
        return new TreeNode(obj);
    }
    if (obj.compareTo((String)t.getValue()) < 0) {
        t.setLeft(addBalanced(t.getLeft(), obj));
    } else {
        t.setRight(addBalanced(t.getRight(), obj));
    }
    int balance = calcBalance(t);
    if (balance == -2 || balance == 2) 
    {
        if (balance == 2) 
        {
            if (obj.compareTo((String)t.getRight().getValue()) > 0) 
            {
                t = ll(t);
            } 
            else 
            {
               return lr(t);
            }
        } 
        else 
        {
            if (obj.compareTo((String)t.getLeft().getValue()) < 0) 
            {
                t = rr(t);
            } 
            else 
            {
                return rl(t);            
            }
        }
    }
    return t;   }
   
   /*  write the four rotation methods   */
   private TreeNode ll(TreeNode t)
   {  // c is just t
      TreeNode center = t.getRight();
      t.setRight(center.getLeft());
      center.setLeft(t);
      return center;
   }

   private TreeNode rr(TreeNode t)
   {  
      TreeNode center = t.getLeft();
      t.setLeft(center.getRight());
      center.setRight(t);
      return center;
      
      
   }
   private TreeNode lr(TreeNode t)
   {
      t.setRight(rr(t.getRight()));
      return ll(t);
     
   }
   private TreeNode rl(TreeNode t)
   {
    t.setLeft(ll(t.getLeft()));
    return rr(t);
    //a is just c in this method
      
   }
   
}