//Name:
//Date:

/* Resource classes and interfaces
 * for use with Graph0 AdjMat_0_Driver,
 *              Graph1 WarshallDriver,
 *          and Graph2 FloydDriver
 */

import java.util.*;
import java.io.*;

interface AdjacencyMatrix
{
   public int[][] getGrid();
   public int[][] readGrid(String fileName);
   public boolean isNeighbor(int from, int to);
   public int countEdges();
   public List<Integer> getNeighbors(int source);
   public String showAllNeighbors();
   public String toString();  //returns the grid as a String
}

interface WithNames
{
   public void readNames(String fileName);
   public Map<String, Integer> getNamesAndNumbers();
   public String toStringNamesAndNumbers();  // each line contains number-name, ex: 0-Pendleton
   public boolean isNeighbor(String from, String to);
}
  
interface Warshall
{    
   public int countReachables();
   public boolean isReachable(String from, String to);  
   public List<String> getReachables(String from);
   public String toStringReachability(); //displays the reachability matrix with 2 spaces in front of each value
   public void allPairsReachability();   // Warshall's Algorithm. fills the reachability matrix                                  
}

interface Floyd
{
   public int getCost(int from, int to);
   public int getCost(String from, String to);
   public void allPairsWeighted();  //Floyd's Algorithm
}

/***********************  the graph  ******************/
public class AdjMat implements AdjacencyMatrix//, WithNames//, Warshall//, Floyd
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> namesAndNumbers = null;    // maps name to number
   private  ArrayList<String> nameList = null;  //reverses the map, index-->name
   private int[][] reachability = null; //reachability matrix for Warshall, cost matrix for Floyd
 
 /*  write constructors, accessor methods, and instance methods   */  
   public AdjMat(String filename)
   {
      grid = readGrid(filename);
   }
   public AdjMat(String file1, String file2)
   {
      grid = readGrid(file1);
      reachability = readGrid(file1);
      namesAndNumbers = new TreeMap<String,Integer>();
      nameList = new ArrayList<String>();
      readNames(file2);
   }
   public int[][] getGrid()
   {
      return grid;
   }
   public int[][] readGrid(String fileName)
   {
      try{
         Scanner infile = new Scanner(new FileReader(fileName));
         int size = infile.nextInt();
         int[][] temp = new int[size][size];
         for(int r = 0; r < size; r++)
            for(int c = 0; c < size; c++)
               temp[r][c] = infile.nextInt();
         
         infile.close();
         return temp;
         
      }
      catch(FileNotFoundException e)
      {
            
      }
      return null; // default return statement
   }
   public boolean isNeighbor(int from, int to)
   {
      return grid[from][to] != 0;
   }
   public int countEdges()
   {
     int count = 0;
     for(int r = 0; r < grid.length; r++)
     {
         for(int c = 0; c < grid.length;c++)
         {
            if(grid[r][c] != 0)
            {
               count++;
            }
         }
     }
     return count;
   }
   public List<Integer> getNeighbors(int source)
   {  
      List<Integer> list = new ArrayList<Integer>();
      for(int c = 0; c < grid.length;c++)
      {
         if(grid[source][c]==1)
         {
            list.add(c);
         }
      }
      return list;
         
      // check the source row, add non-zero col into the list
   }
   public String showAllNeighbors()
   {  
      String str = "";
      boolean comma = false;
      for(int i = 0; i < grid.length; i++)
      {
         List<Integer> neighbors = getNeighbors(i);
         str += i + ": " + neighbors + "\n";
         
      }
      return str;
      
   }
   public String toString()
   {  
      String accumulate = "";
      for(int[] r:grid)
      {
         for(int c:r){
            accumulate += c + " ";
         }
         accumulate += "\n";
      }
      return accumulate;
   }  //returns the grid as a String
   
   
   
   
   /**************  implement the WithNames interface ************/
   public void readNames(String filename)
   {
      try
      {
         Scanner infile = new Scanner(new File(filename));
         int size = infile.nextInt();
         for(int i =0;i<size;i++)
         {
            String name = infile.next();
            namesAndNumbers.put(name,i);
            nameList.add(name);
         }
      }
      catch(FileNotFoundException e)
      {
      
      }
      
   }
   public Map<String, Integer> getNamesAndNumbers()
   {
      return namesAndNumbers;
   }
   public String toStringNamesAndNumbers()
   {
      return "";
   }
   public boolean isNeighbor(String from, String to)
   {

    if (namesAndNumbers.containsKey(from) && namesAndNumbers.containsKey(to)) {
        int fromIndex = namesAndNumbers.get(from);
        int toIndex = namesAndNumbers.get(to);
        return grid[fromIndex][toIndex] != 0;
    }
  
    return false;
   }
   /************  implement the Warshall interface ************/
   public int countReachables()
   {
      int reachable = 0;
      for(int[]row:reachability)
      {
         for(int col:row)
         {
            reachable += col;
         }
      }
      return reachable;
   }
   public boolean isReachable(String from, String to)
   {  
      return reachability[namesAndNumbers.get(from)][namesAndNumbers.get(to)]>0;
   }  
   public List<String> getReachables(String from)
   {
      List<String> list = new ArrayList<String>();
      for(String r:nameList )
      {
         if(isReachable(from,r))
         {
            list.add(r);
         }
      }
      return list;
   }
   public String toStringReachability()
   {
      String accumulate = "";
      for(int[] r: reachability)
      {
         for(int c:r)
         {
            accumulate += " " + c + " ";
         }
         accumulate += "\n";
      }
      return accumulate;
   } 
   
   public void allPairsReachability()
   {
         for(int bridge = 0; bridge<grid.length;bridge++)
         {
            for(int from = 0; from<grid.length;from++)
            {
               for(int to = 0; to<grid.length;to++)
               {
                  if(reachability[from][bridge] == 1 && reachability[bridge][to]==1)
                  {
                     reachability[from][to] = 1;
                  }
               }
            }
         }
      
   }   // Warshall's Algorithm. fills the reachability matrix 
  
  
        
   /*************  implement the Floyd interface  *********/
   public int getCost(int from, int to)
   {
      return reachability[from][to];
   }
   public int getCost(String from, String to)
   {
      return reachability[namesAndNumbers.get(from)][namesAndNumbers.get(to)];
   }
   public void allPairsWeighted()
   {
      for(int bridge = 0; bridge<grid.length;bridge++)
         {
            for(int from = 0; from<grid.length;from++)
            {
               for(int to = 0; to<grid.length;to++)
               {
                  int temper1 = reachability[from][bridge];
                  int temper2 = reachability[bridge][to];
                  int total = temper1+temper2;
                  if(temper1>0 && temper2>0 && temper1<9999 && temper2<9999 && total<reachability[from][to])
                  {
                     reachability[from][to] = total;
                  }
               }
            }
         }

   }  //Floyd's Algorithm
  
  
  
}