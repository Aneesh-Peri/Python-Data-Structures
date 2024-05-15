// Name:
// Date: 

interface BST_Generic_interface<E>
{
   public int size();
   public TreeNode<E> getRoot() ;
   public boolean contains(E obj);
   public void add(E obj);         //does not balance
   public void addBalanced(E obj); //AVL
   public void remove(E obj);      //does not balance
   public E min();
   public E max();
   public String display();
   public String toString();
}

/*******************
Copy your BST code.  Implement generics.
If you skipped remove() and/or addBalanced(), just leave the method bodies empty.
**********************/
public class BST_Generic<E extends Comparable<E>> implements BST_Generic_interface<E>
{
   private TreeNode<E> root;
   private int size;
   public BST_Generic()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
     return size;
   }
   public TreeNode<E> getRoot()   //accessor method
   {
      return root;
   }
   /***************************************
   @param s -- one string to be inserted
   ****************************************/
   public void add(E s) 
   {
      size++;
      root = add(root, s);
   }
   private TreeNode<E> add(TreeNode<E> t, E s) //recursive helper method
   {      
      if(t==null)
      {
         return new TreeNode<E>(s);  
      }
      if((t.getValue()).compareTo(s)>=0)
      {
            t.setLeft(add(t.getLeft(),s));
      }
      else if((t.getValue()).compareTo(s)<=0)
      {
            t.setRight(add(t.getRight(),s));
      }
      
      return t; 
   }
    
   public String display()
   {
       return display(root, 0);
   }
   private String display(TreeNode<E> t, int level) //recursive helper method
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
   
   public boolean contains(E obj)
   {
      return contains(root,obj);
   }
   private boolean contains(TreeNode<E> t, E x) //recursive helper method
   {
      if(t==null)
      {
         return false;
       }
      if((t.getValue()).compareTo(x)==0)
      {
         return true;
      }
      else if((t.getValue()).compareTo(x)<0)
      {
         return contains(t.getRight(),x);
      }
         return contains(t.getLeft(),x);     
   }
   
   public E min()
   {
      return min(root);
   }
   private E min(TreeNode<E> t)  //use iteration
   {
      if( t == null )
         return null;
      if(t.getLeft()==null)
      {
         return t.getValue();
      }
      return max(t.getLeft());
   }
   
   public E max()
   {
      return max(root);
   }
   private E max(TreeNode<E> t)  //recursive helper method
   {
      if( t == null )
         return null;
      if(t.getRight()==null)
      {
         return t.getValue();
      }
      return max(t.getRight());
   }
   
   public String toString()
   {
      return toString(root);
   }
   private String toString(TreeNode<E> t)  //an in-order traversal.  Use recursion.
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
   public void remove(E target)
   {
      root = remove(root, target);
      size--;
   }
   private TreeNode remove(TreeNode<E> current, E target)
   {     
      if(current == null)
         return null;
      E value = (current.getValue());
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
            E highestVal = max(current.getLeft()); // find biggest value in left subtree
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
   private int calcBalance(TreeNode<E> current) //height to right minus 
   {                                         //height to left
      return height(current.getRight()) - height(current.getLeft());
   }
 
  private int height(TreeNode<E> current)   //from TreeLab
   {
       if(current==null)
           return -1;
       if(current.getLeft() == null && current.getRight() == null)
           return 0;
       else
           return Math.max(1+height(current.getLeft()),1+height(current.getRight()));
   }
   
 
   public void addBalanced(E value)  
   {
      root = addBalanced(root,value);
      size++;
   }
   
   //helper method for second approach
   private TreeNode addBalanced(TreeNode<E> t, E obj)
   {
      if (t == null) {
        return new TreeNode(obj);
    }
    if (obj.compareTo(t.getValue()) < 0) {
        t.setLeft(addBalanced(t.getLeft(), obj));
    } else {
        t.setRight(addBalanced(t.getRight(), obj));
    }
    int balance = calcBalance(t);
    if (balance == -2 || balance == 2) 
    {
        if (balance == 2) 
        {
            if (obj.compareTo(t.getRight().getValue()) > 0) 
            {
                t = ll(t);
            } 
            else 
            {
               t.setRight(rr(t.getRight()));
                t = ll(t);
            }
        } 
        else 
        {
            if (obj.compareTo(t.getLeft().getValue()) < 0) 
            {
                t = rr(t);
            } 
            else 
            {
                t.setLeft(ll(t.getLeft()));
                t = rr(t);
            }
        }
    }
    return t;   }
   
   /*  write the four rotation methods   */
   private TreeNode<E> ll(TreeNode<E> t)
   {  // c is just t
      TreeNode<E> center = t.getRight();
      t.setRight(center.getLeft());
      center.setLeft(t);
      return center;
   }

   private TreeNode<E> rr(TreeNode<E> t)
   {  
      TreeNode<E> center = t.getLeft();
      t.setLeft(center.getRight());
      center.setRight(t);
      return center;
      
      
   }
   private TreeNode<E> lr(TreeNode<E> t)
   {
      t.setRight(rr(t.getRight()));
      return ll(t);
     
   }
   private TreeNode<E> rl(TreeNode<E> t)
   {
    t.setLeft(ll(t.getLeft()));
    return rr(t);
    //a is just c in this method
      
   }
   
}

/*******************
  Copy your TreeNode code.  Implement generics.
**********************/
class TreeNode<E>
{
   private E value; 
   private TreeNode<E> left, right;
   
   public TreeNode(E initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(E initValue, TreeNode<E> initLeft, TreeNode<E> initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public E getValue()
   { 
      return value; 
   }
   
   public TreeNode<E> getLeft() 
   { 
      return left; 
   }
   
   public TreeNode<E> getRight() 
   { 
      return right; 
   }
   
   public void setValue(E theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode<E> theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode<E> theNewRight)
   { 
      right = theNewRight;
   }
}