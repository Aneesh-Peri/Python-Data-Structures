// name:        date: 
import java.util.*;
import java.io.*;

/**
  * This binary tree node class stores two values.  Otherwise, it acts like a TreeNode.
  * The compareTo method must ensure that the lowest frequency has the highest priority.
  */
class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
{
   private String letter;
   private Integer freq; 
   private HuffmanTreeNode left, right;
   //constructor, modifiers, accessors, toString, Comparable
   
   
}


public class Huffman
{
   public static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) throws IOException
   {
      //Prompt for two strings 
      System.out.print("Encoding using Huffman codes");
      System.out.print("\nWhat message? ");
      String message = keyboard.nextLine();
   
      System.out.print("\nEnter middle part of filename:  ");
      String middlePart = keyboard.next();
   
      huffmanize( message, middlePart );
   }
   
   //Make a frequency table of the letters
   //Put each letter-frequency pair into a HuffmanTreeNode. Put each 
   //        node into a priority queue (or a min-heap).     
  	//Use the priority queue of nodes to build the Huffman tree
   //Make a map to store the scheme.  As you recur through the tree,
   //      build the path where going left concatenates "0" and going
   //      going right concatenates "1".
   //Process the string letter-by-letter and use the map to output the
   //      binary message to a file. 
   //Process the map to output the scheme to a file.  
   public static void huffmanize(String message, String middlePart) throws IOException
   {
   
   }
   
   //returns the frequency table using the most efficient data structure
   public static Map<String, Integer> makeFrequency(String message)
   {
      return null;
   }
   
   //creates the initial PriorityQueue that has in it the nodes for all the characters and their priority
   public static PriorityQueue<HuffmanTreeNode> makeQueue(Map<String, Integer> freqTable)
   {
      return null;
   }
   
   //returns the root of the HuffmanTreeNode you created
   //the higher characters nodes should be closer to the root than the lower frequency ones 
   public static HuffmanTreeNode makeTree(PriorityQueue<HuffmanTreeNode> heap)
   {
      return null;
   }

   public static Map<String, String> makeSchemeMap( HuffmanTreeNode root )
   {
      return null;
   }
   
  // this helper method is recursive. Base case: when you reach a leaf, put the 
  //     letter and its path in a map.  Recursively build the path, 
  //     concatenating a "0" when you go left and a "1" when going right.
   private static void makeSchemeMapHelper( HuffmanTreeNode t, String path, Map<String, String> mapScheme)
   {
   
   }
 
    //postcondition: process the map twice to make the files.              
   public static void makeFiles(Map<String, String> mapScheme, String message, String middlePart) throws IOException
   {
   
   }
}
